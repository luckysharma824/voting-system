package com.asorg.votingsystem.service;

import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;
    public void addCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public Candidate findCandidate(Integer id) {
        return candidateRepository.findById(id).orElse(null);
    }

    public List<Candidate> listByElections(Integer eId) {
        ElectionDetail electionDetail = new ElectionDetail();
        electionDetail.setId(eId);
        return candidateRepository.findByElectionDetail(electionDetail);
    }
}
