package com.asorg.votingsystem.service;

import com.asorg.votingsystem.dto.PartyDetailDto;
import com.asorg.votingsystem.entity.Identity;
import com.asorg.votingsystem.entity.PartyDetail;
import com.asorg.votingsystem.repository.IdentityRepository;
import com.asorg.votingsystem.repository.PartyDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyDetailService {
    @Autowired
    private PartyDetailRepository partyDetailRepository;
    public PartyDetail addPartyDetail(PartyDetailDto partyDetail){
        boolean isExists = partyDetailRepository.existsByNameAndSymbol(partyDetail.getName(), partyDetail.getSymbol());
        if (!isExists) {
            PartyDetail party = new PartyDetail();
            party.setName(partyDetail.getName());
            party.setSymbol(partyDetail.getSymbol());
            party.setStatus(partyDetail.getStatus());
            return partyDetailRepository.save(party);
        }
        return null;
    }


    public PartyDetail editPartyDetail(PartyDetail partyDetail) {
        Optional<PartyDetail> optionalParty = partyDetailRepository.findById(partyDetail.getId());
        if (optionalParty.isPresent()) {
            PartyDetail existing = optionalParty.get();
            existing.setName(partyDetail.getName());
            existing.setSymbol(partyDetail.getSymbol());
            existing.setStatus(partyDetail.getStatus());
            return partyDetailRepository.save(partyDetail);
        }
        return null;
    }
    public PartyDetail findPartyDetail(Integer id){
      return partyDetailRepository.findById(id).orElse(null);
    }

    public List<PartyDetail> findAllParties() {
        return  partyDetailRepository.findAll();
    }

    public void deleteParty(Integer id) {
        partyDetailRepository.deleteById(id);
    }
}
