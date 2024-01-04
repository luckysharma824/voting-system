package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.dto.PartyDetailDto;
import com.asorg.votingsystem.entity.PartyDetail;
import com.asorg.votingsystem.service.PartyDetailService;
import com.asorg.votingsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
public class PartyDetailController {
    @Autowired
    PartyDetailService partyDetailService;
    @PostMapping("/partydetail")
    public ResponseEntity<Object> addPartyDetail(@RequestBody PartyDetailDto partyDetail){
        PartyDetail party = partyDetailService.addPartyDetail(partyDetail);
        boolean isSuccess = false;
        String message = "Already exists";
        if (party != null) {
            isSuccess = true;
            message = "Successfully stored";
        }
        return Response.handleResponse(party, message, isSuccess, HttpStatus.OK);
    }

    @PutMapping("/partydetail")
    public ResponseEntity<Object> editPartyDetail(@RequestBody PartyDetailDto partyDetail){
        PartyDetail party = partyDetailService.editPartyDetail(partyDetail);
        boolean isSuccess = false;
        String message = "Party Detail already exists!";
        if (party != null) {
            isSuccess = true;
            message = "Details Successfully updated";
        }
        return Response.handleResponse(party, message, isSuccess, HttpStatus.OK);
    }

    @GetMapping("/partydetail")
    public PartyDetail getPartyDetail(@RequestParam Integer id) {
        return partyDetailService .findPartyDetail(id);

    }
    @GetMapping("/partydetail/all")
    public List<PartyDetail> getPartyDetailList() {
        return partyDetailService.findAllParties();
    }

    @DeleteMapping(value = "/partydetail")
    public ResponseEntity<Object> deleteParty(@RequestParam Integer id) {
        return partyDetailService.deleteParty(id);
    }
}
