package com.asorg.votingsystem.service;

import com.asorg.votingsystem.dto.VoterDto;
import com.asorg.votingsystem.entity.BoothDetail;
import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.entity.Voter;
import com.asorg.votingsystem.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterService {
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidateService candidateService;

    public Voter addVoter(VoterDto voterDto) {
        Voter voter = voterRepository.findByVoterIdOrUsername(voterDto.getVoterId(), voterDto.getUsername());
        if (voter == null) {
            voter = new Voter();
            voter.setName(voterDto.getName());
            voter.setUsername(voterDto.getUsername());
            voter.setVoterId(voterDto.getVoterId());
            voter.setPassword(voterDto.getPassword());
            voter.setStatus(voterDto.getStatus());
            BoothDetail boothDetail = new BoothDetail();
            boothDetail.setId(voterDto.getBooth().getId());
            voter.setBooth(boothDetail);
            return voterRepository.save(voter);
        }
        return null;
    }

    public Voter findVoter(Integer id) {
        return voterRepository.findById(id).orElse(null);
    }

    public void doVote(Integer canId) {
        Candidate cand = candidateService.findCandidate(canId);
        if (cand != null) {
            cand.setTotalVotes(cand.getTotalVotes() + 1);
            candidateService.saveCandidate(cand);
        }
    }
}
