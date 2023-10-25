package com.asorg.votingsystem.service;

import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.repository.ElectionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionDetailService {
    @Autowired
    private ElectionDetailRepository electionDetailRepository;
    public void addElectionDetail(ElectionDetail electionDetail){
        electionDetailRepository.save(electionDetail);
    }
    public ElectionDetail findElectionDetail(Integer id){
        return electionDetailRepository.findById(id).orElse(null);
    }
}
