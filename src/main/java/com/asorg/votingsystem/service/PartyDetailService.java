package com.asorg.votingsystem.service;

import com.asorg.votingsystem.entity.Identity;
import com.asorg.votingsystem.entity.PartyDetail;
import com.asorg.votingsystem.repository.IdentityRepository;
import com.asorg.votingsystem.repository.PartyDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyDetailService {
    @Autowired
    private PartyDetailRepository partyDetailRepository;
    public void addPartyDetail(PartyDetail partyDetail){
        partyDetailRepository.save(partyDetail);
    }
    public PartyDetail findPartyDetail(Integer id){
      return partyDetailRepository.findById(id).orElse(null);
    }
}
