package com.asorg.votingsystem.service;

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

    public void addVoter(Voter voter) {
        voterRepository.save(voter);
    }

    public Voter findVoter(Integer id) {
        return voterRepository.findById(id).orElse(null);
    }

    public void doVote(Integer canId) {
        Candidate cand = candidateService.findCandidate(canId);
        if (cand != null) {
            cand.setTotalVotes(cand.getTotalVotes() + 1);
            candidateService.addCandidate(cand);
        }
    }
}
