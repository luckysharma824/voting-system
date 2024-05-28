package com.asorg.votingsystem.service;

import com.asorg.votingsystem.dto.VoterDto;
import com.asorg.votingsystem.entity.BoothDetail;
import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.entity.Voter;
import com.asorg.votingsystem.enums.StatusEnum;
import com.asorg.votingsystem.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterService {
    @Autowired
    private VoterRepository voterRepository;

    public Voter addVoter(VoterDto voterDto) {
        Voter voter = voterRepository.findByVoterId(voterDto.getVoterId());
        if (voter == null) {
            voter = new Voter();
            voter.setName(voterDto.getName());
            voter.setVoterId(voterDto.getVoterId());
            BoothDetail boothDetail = new BoothDetail();
            boothDetail.setId(voterDto.getBooth().getId());
            voter.setBooth(boothDetail);
            voter.setContact(voterDto.getContact());
            voter.setStatus(StatusEnum.ACTIVE);
            return voterRepository.save(voter);
        }
        return null;
    }

    public Voter findVoter(Integer id) {
        return voterRepository.findById(id).orElse(null);
    }

    public Voter findByVoterId(String voterId) {
        return voterRepository.findByVoterId(voterId);
    }
}
