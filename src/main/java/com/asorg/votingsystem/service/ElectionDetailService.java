package com.asorg.votingsystem.service;

import com.asorg.votingsystem.dto.ElectionDetailDto;
import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.enums.StateEnum;
import com.asorg.votingsystem.repository.ElectionDetailRepository;
import com.asorg.votingsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ElectionDetailService {
    @Autowired
    private ElectionDetailRepository electionDetailRepository;
    @Autowired
    private CandidateService candidateService;
    public ElectionDetail addElectionDetail(ElectionDetailDto electionDetailDto){
        boolean isExists = electionDetailRepository.existsByElectionTypeAndState(electionDetailDto.getElectionType(),
                electionDetailDto.getState());
        if (!isExists) {
            ElectionDetail electionDetail = new ElectionDetail();
            electionDetail.setElectionType(electionDetailDto.getElectionType());
            electionDetail.setState(electionDetailDto.getState());
            electionDetail.setVotingStatus(electionDetailDto.getVotingStatus());
            return electionDetailRepository.save(electionDetail);
        }
        return null;
    }

    public ElectionDetail editElectionDetail(ElectionDetailDto electionDetail) {
        Optional<ElectionDetail> existsOp = electionDetailRepository.findById(electionDetail.getId());

        if (existsOp.isPresent()) {
            ElectionDetail otherWithSameField = electionDetailRepository.findByElectionTypeAndState(
                    electionDetail.getElectionType(), electionDetail.getState());
            if (otherWithSameField == null || Objects.equals(otherWithSameField.getId(), existsOp.get().getId())) {
                ElectionDetail existingEl = existsOp.get();
                existingEl.setElectionType(electionDetail.getElectionType());
                existingEl.setState(electionDetail.getState());
                existingEl.setVotingStatus(electionDetail.getVotingStatus());
                return electionDetailRepository.save(existingEl);
            }
        }
        return null;
    }
    public ElectionDetail findElectionDetail(Integer id){
        return electionDetailRepository.findById(id).orElse(null);
    }

    public List<ElectionDetail> electionDetailList(StateEnum state) {
        return electionDetailRepository.findByState(state);
    }

    public ResponseEntity<Object> deleteElectionDetail(Integer id) {
        if (candidateService.existsCandidateByElections(id)) {
            return Response.handleResponse("Candidates found, Please remove them first", false, HttpStatus.OK);
        }
        electionDetailRepository.deleteById(id);
        return Response.handleResponse("Election Detail successfully deleted", true, HttpStatus.OK);
    }
}
