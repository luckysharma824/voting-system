package com.asorg.votingsystem.service;

import com.asorg.votingsystem.entity.BoothDetail;
import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.repository.BoothDetailRepository;
import com.asorg.votingsystem.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoothDetailService {

    @Autowired
    private BoothDetailRepository boothDetailRepository;

    public void addBooth(BoothDetail boothDetail) {
        boothDetailRepository.save(boothDetail);
    }

    public BoothDetail findBoothDetail(Integer id) {
        Optional<BoothDetail> boothDetail = boothDetailRepository.findById(id);
        return boothDetail.orElse(null);
    }
}
