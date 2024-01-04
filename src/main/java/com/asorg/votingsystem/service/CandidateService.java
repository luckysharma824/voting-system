package com.asorg.votingsystem.service;

import com.asorg.votingsystem.dto.CandidateDto;
import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.entity.PartyDetail;
import com.asorg.votingsystem.enums.StateEnum;
import com.asorg.votingsystem.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate addCandidate(CandidateDto candidate) {
        Candidate existing = candidateRepository.findByElectionDetailAndPartyDetail(
                candidate.getElectionDetail(), candidate.getPartyDetail());
        if (existing == null) {
            Candidate newCandidate = new Candidate();
            newCandidate.setName(candidate.getName());
            newCandidate.setPartyDetail(candidate.getPartyDetail());
            newCandidate.setElectionDetail(candidate.getElectionDetail());
            newCandidate.setTotalVotes(0L);
            return saveCandidate(newCandidate);
        }
        return null;
    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(CandidateDto candidate) {
        Optional<Candidate> existingOp = candidateRepository.findById(candidate.getId());
        if (existingOp.isPresent()) {
            Candidate existing = candidateRepository.findByElectionDetailAndPartyDetail(
                    candidate.getElectionDetail(), candidate.getPartyDetail());
            if (existing == null || Objects.equals(existing.getId(), existingOp.get().getId())) {
                Candidate existingCand = existingOp.get();
                existingCand.setName(candidate.getName());
                existingCand.setPartyDetail(candidate.getPartyDetail());
                existingCand.setElectionDetail(candidate.getElectionDetail());
                return saveCandidate(existingCand);
            }
        }
        return null;
    }

    public Candidate findCandidate(Integer id) {
        return candidateRepository.findById(id).orElse(null);
    }

    public void deleteCandidate(Integer id) {
        candidateRepository.deleteById(id);
    }

    public List<Candidate> listByElections(Integer eId) {
        ElectionDetail electionDetail = new ElectionDetail();
        electionDetail.setId(eId);
        return candidateRepository.findByElectionDetail(electionDetail);
    }

    public boolean existsCandidateByElections(Integer electId) {
        return candidateRepository.existsByElectionDetail(new ElectionDetail(electId, null, null, null));
    }

    public boolean existsCandidateByPartyDetail(Integer partyId) {
        return candidateRepository.existsByPartyDetail(new PartyDetail(partyId, null, null, null));
    }
    public List<Candidate> fetchCandidatesByStates(StateEnum state) {
        return candidateRepository.findByElectionDetail_State(state);
    }
}
