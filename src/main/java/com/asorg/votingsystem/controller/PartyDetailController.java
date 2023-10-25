package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.entity.Identity;
import com.asorg.votingsystem.entity.PartyDetail;
import com.asorg.votingsystem.service.PartyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;

@RestController
public class PartyDetailController {
    @Autowired
    PartyDetailService partyDetailService;
    @PostMapping("/partydetail")
    public PartyDetail addPartyDetail(@RequestBody PartyDetail partyDetail){
       partyDetailService.addPartyDetail(partyDetail);
        return partyDetail;

    }

    @GetMapping("/partydetail")
    public PartyDetail getPartyDetail(@RequestParam Integer id) {
        return   partyDetailService .findPartyDetail(id);

    }
}
