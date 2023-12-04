package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.entity.Voter;
import com.asorg.votingsystem.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class VoterController {
    @Autowired
    VoterService voterService;
    @PostMapping("/voter")
    public Voter addVoter(@RequestBody Voter voter) {
        voterService.addVoter(voter);
        return voter;
    }
    @GetMapping("/voter")
    public Voter getVoter(@RequestParam Integer id){
        return voterService.findVoter(id);
    }

    @PostMapping(value = "/voting")
    public String doVote(@RequestParam Integer candId) {
        voterService.doVote(candId);
        return "voting successfully done";
    }


}
