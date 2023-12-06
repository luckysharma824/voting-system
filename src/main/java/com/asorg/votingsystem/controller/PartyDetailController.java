package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.entity.PartyDetail;
import com.asorg.votingsystem.service.PartyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PartyDetailController {
    @Autowired
    PartyDetailService partyDetailService;
    @PostMapping("/partydetail")
    public PartyDetail addPartyDetail(@RequestBody PartyDetail partyDetail){
       partyDetailService.addPartyDetail(partyDetail);
        return partyDetail;

    }

    @PutMapping("/partydetail")
    public PartyDetail editPartyDetail(@RequestBody PartyDetail partyDetail){
        partyDetailService.editPartyDetail(partyDetail);
        return partyDetail;
    }

    @GetMapping("/partydetail")
    public PartyDetail getPartyDetail(@RequestParam Integer id) {
        return   partyDetailService .findPartyDetail(id);

    }
    @GetMapping("/partydetail/all")
    public List<PartyDetail> getPartyDetailList() {
        return partyDetailService.findAllParties();
    }

    @DeleteMapping(value = "/partydetail")
    public Map<String, String> deleteParty(@RequestParam Integer id) {
        Map<String, String> response = new LinkedHashMap<>();
        partyDetailService.deleteParty(id);
        response.put("message", "Record successfully deleted");
        return response;
    }
}
