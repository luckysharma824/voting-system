package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.dto.VoterDto;
import com.asorg.votingsystem.entity.Voter;
import com.asorg.votingsystem.service.VoterService;
import com.asorg.votingsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class VoterController {
    @Autowired
    VoterService voterService;
    @PostMapping("/voter")
    public ResponseEntity<Object> addVoter(@RequestBody VoterDto voterDto) {
        Voter voter = voterService.addVoter(voterDto);
        if (voter == null) {
            return Response.handleResponse("Voter already registered with voter id or username",
                    false, HttpStatus.OK);
        }
        return Response.handleResponse(voter, "voter successfully added", true, HttpStatus.OK);
    }

    @GetMapping("/voter")
    public ResponseEntity<Object> getVoter(@RequestParam Integer id){
        return Response.handleResponse(voterService.findVoter(id), "successfully fetched",
                true, HttpStatus.OK);
    }

    @PostMapping(value = "/voting")
    public ResponseEntity<Object> doVote(@RequestParam("candId") Integer candId) {
        voterService.doVote(candId);
        return Response.handleResponse("voting successfully done", true, HttpStatus.OK);
    }


}
