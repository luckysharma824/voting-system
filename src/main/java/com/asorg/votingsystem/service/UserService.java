package com.asorg.votingsystem.service;

import com.asorg.votingsystem.dto.UserDto;
import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.entity.OneTimePassword;
import com.asorg.votingsystem.entity.User;
import com.asorg.votingsystem.entity.Voter;
import com.asorg.votingsystem.enums.StatusEnum;
import com.asorg.votingsystem.exception.ServiceException;
import com.asorg.votingsystem.repository.OtpRepository;
import com.asorg.votingsystem.repository.UserRepository;
import com.asorg.votingsystem.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpRepository otpRepository;

    public User register(UserDto userDto, Voter voter) throws ServiceException {
        User user = userRepository.findByVoterOrUsername(voter, userDto.getUsername());
        if (user != null) {
            throw new ServiceException("EC-EXISTS", "User Already Exists");
        }
        user = new User();
        user.setVoter(voter);
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setStatus(StatusEnum.INACTIVE);
        return userRepository.save(user);
    }

    public StatusEnum userStatus(Integer userId) {
        return userRepository.findStatusById(userId);
    }

    public void doVote(Integer canId) {
        Candidate cand = candidateService.findCandidate(canId);
        if (cand != null) {
            cand.setTotalVotes(cand.getTotalVotes() + 1);
            candidateService.saveCandidate(cand);
        }
    }

    public void sentOtp(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ServiceException("EC-NOT-EXISTS", "User does not exist");
        }
        long time = System.currentTimeMillis() + 1000 * 60 * 15;
        OneTimePassword oneTimePassword = otpRepository.findByUserId(user.getId());
        if (oneTimePassword == null) {
            oneTimePassword = new OneTimePassword(null, NumberUtils.getRandomNumberString(), time, user.getId());
        } else {
            if (oneTimePassword.getExpiresIn() >= System.currentTimeMillis()) {
                oneTimePassword.setExpiresIn(time);
                oneTimePassword.setOtp(NumberUtils.getRandomNumberString());
            }
        }
        LOGGER.info("USER VERIFICATION OTP CODE: {}", oneTimePassword.getOtp());
        otpRepository.save(oneTimePassword);
    }

    public User verifyOtp(String otp, String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ServiceException("EC-NOT-EXISTS", "User does not exist");
        }
        OneTimePassword oneTimePassword = otpRepository.findByOtpAndUserId(otp, user.getId());
        if (oneTimePassword == null) {
            throw new ServiceException("EC-INVALID", "OTP Invalid");
        }
        if (oneTimePassword.getExpiresIn() < System.currentTimeMillis()) {
            throw new ServiceException("EC-EXIPIRE", "OTP Expired");
        }
        if (!oneTimePassword.getOtp().equals(otp)) {
            throw new ServiceException("EC-NOT-MATCH", "OTP Doesn't Match");
        }
        otpRepository.delete(oneTimePassword);
        user.setStatus(StatusEnum.ACTIVE);
        return userRepository.save(user);
    }

}
