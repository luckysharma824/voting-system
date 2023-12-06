package com.asorg.votingsystem.service;

import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.enums.StateEnum;
import com.asorg.votingsystem.repository.ElectionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionDetailService {
    @Autowired
    private ElectionDetailRepository electionDetailRepository;
    public void addElectionDetail(ElectionDetail electionDetail){
        electionDetailRepository.save(electionDetail);
    }

    public void editElectionDetail(ElectionDetail electionDetail) {
        Optional<ElectionDetail> existsOp = electionDetailRepository.findById(electionDetail.getId());
        if (existsOp.isPresent()) {
            ElectionDetail existingEl = existsOp.get();
            existingEl.setElectionType(electionDetail.getElectionType());
            existingEl.setState(electionDetail.getState());
            existingEl.setVotingStatus(electionDetail.getVotingStatus());
            electionDetailRepository.save(electionDetail);
        }
    }
    public ElectionDetail findElectionDetail(Integer id){
        return electionDetailRepository.findById(id).orElse(null);
    }

    public List<ElectionDetail> electionDetailList(StateEnum state) {
        return electionDetailRepository.findByState(state);
    }

}
