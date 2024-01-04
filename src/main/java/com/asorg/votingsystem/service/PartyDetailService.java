package com.asorg.votingsystem.service;

import com.asorg.votingsystem.dto.PartyDetailDto;
import com.asorg.votingsystem.entity.PartyDetail;
import com.asorg.votingsystem.repository.PartyDetailRepository;
import com.asorg.votingsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PartyDetailService {
    @Autowired
    private PartyDetailRepository partyDetailRepository;

    @Autowired
    private CandidateService candidateService;
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


    public PartyDetail editPartyDetail(PartyDetailDto partyDetail) {
        Optional<PartyDetail> optionalParty = partyDetailRepository.findById(partyDetail.getId());
        if (optionalParty.isPresent()) {
            PartyDetail sameDetailParty = partyDetailRepository.findByNameAndSymbol(
                    partyDetail.getName(),partyDetail.getSymbol());
            if (sameDetailParty == null || Objects.equals(optionalParty.get().getId(), sameDetailParty.getId())) {
                PartyDetail existing = optionalParty.get();
                existing.setName(partyDetail.getName());
                existing.setSymbol(partyDetail.getSymbol());
                existing.setStatus(partyDetail.getStatus());
                return partyDetailRepository.save(existing);
            }
        }
        return null;
    }
    public PartyDetail findPartyDetail(Integer id){
      return partyDetailRepository.findById(id).orElse(null);
    }

    public List<PartyDetail> findAllParties() {
        return  partyDetailRepository.findAll();
    }

    public ResponseEntity<Object> deleteParty(Integer id) {
        if (candidateService.existsCandidateByPartyDetail(id)) {
            return Response.handleResponse("Candidates found, Please remove them first", false, HttpStatus.OK);
        }
        partyDetailRepository.deleteById(id);
        return Response.handleResponse("Party Detail successfully deleted", true, HttpStatus.OK);
    }
}
