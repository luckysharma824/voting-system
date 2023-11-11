package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/candidate")
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        candidateService.addCandidate(candidate);
        return candidate;
    }

    @GetMapping("/candidate")
    public Candidate getCandidate(@RequestParam Integer id) {
        return candidateService.findCandidate(id);
    }

    @GetMapping(value = "/candidate-by-election/{electionId}")
    public List<Candidate> getAllCandidatesByElection(@PathVariable Integer electionId) {
        return candidateService.listByElections(electionId);
    }

}
