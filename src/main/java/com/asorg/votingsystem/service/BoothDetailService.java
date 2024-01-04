package com.asorg.votingsystem.service;

import com.asorg.votingsystem.dto.BoothDetailDto;
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

    public BoothDetail addBooth(BoothDetailDto boothDetail) {
        BoothDetail detail = new BoothDetail();
        detail.setState(boothDetail.getState());
        detail.setDistrict(boothDetail.getDistrict());
        detail.setBlock(boothDetail.getBlock());
        detail.setBooth(boothDetail.getBooth());
        return boothDetailRepository.save(detail);
    }

    public BoothDetail findBoothDetail(Integer id) {
        Optional<BoothDetail> boothDetail = boothDetailRepository.findById(id);
        return boothDetail.orElse(null);
    }
}
