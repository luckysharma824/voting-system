package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.dto.UserDto;
import com.asorg.votingsystem.entity.User;
import com.asorg.votingsystem.entity.Voter;
import com.asorg.votingsystem.enums.StatusEnum;
import com.asorg.votingsystem.exception.ServiceException;
import com.asorg.votingsystem.service.UserService;
import com.asorg.votingsystem.service.VoterService;
import com.asorg.votingsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private VoterService voterService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserDto userDto) {
        Voter voter = voterService.findByVoterId(userDto.getVoterDto().getVoterId());
        if (voter == null) {
            return Response.handleResponse("Voter does not exist", false, HttpStatus.BAD_REQUEST);
        }
        User user = userService.register(userDto, voter);
        return Response.handleResponse(user, "User Successfully Registered, Now Please verify user",
                true, HttpStatus.OK);
    }

    @PostMapping("/otp/send")
    public ResponseEntity<Object> sentOtp(String username) {
        try {
            userService.sentOtp(username);
        } catch (ServiceException ex) {
            return Response.handleResponse(ex.getErrorCode() + ":" + ex.getMessage(), false, HttpStatus.BAD_REQUEST);
        }
        return Response.handleResponse("Otp sent to the registered mobile number or email", true, HttpStatus.OK);
    }

    @PostMapping("/otp/verify")
    public ResponseEntity<Object> verify(@RequestParam String otp, @RequestParam String username) {
        try {
            User user = userService.verifyOtp(otp, username);
            return Response.handleResponse(user, "User verified Successfully", true, HttpStatus.OK);
        } catch (ServiceException ex) {
            return Response.handleResponse(ex.getMessage(), false, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/voting")
    public ResponseEntity<Object> doVote(@RequestParam("candId") Integer candId/*, @RequestParam Integer userId*/) {

        /*StatusEnum status = userService.userStatus(userId);
        if (StatusEnum.INACTIVE.equals(status)) {
            return Response.handleResponse("User Not Active Please Activate The User", false,
                    HttpStatus.BAD_REQUEST);
        }*/

        userService.doVote(candId);
        return Response.handleResponse("voting successfully done", true, HttpStatus.OK);
    }
}
