package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.dto.CandidateDto;
import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.enums.StateEnum;
import com.asorg.votingsystem.service.CandidateService;
import com.asorg.votingsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/candidate")
    public ResponseEntity<Object> addCandidate(@RequestBody CandidateDto candidate) {
        Candidate candidate1 = candidateService.addCandidate(candidate);
        String message = "Candidate Detail Successfully saved.";
        boolean isSuccess = true;
        if (candidate1 == null) {
            isSuccess = false;
            message = "Candidate details already exists for selected party and election detail";
        }
        return Response.handleResponse(candidate1, message, isSuccess, HttpStatus.OK);
    }

    @PutMapping(value = "/candidate")
    public ResponseEntity<Object> editCandidate(CandidateDto candidateDto) {
        Candidate candidate1 = candidateService.updateCandidate(candidateDto);
        String message = "Candidate Detail Successfully updated.";
        boolean isSuccess = true;
        if (candidate1 == null) {
            isSuccess = false;
            message = "Other Candidate details already exists for selected party and election detail";
        }
        return Response.handleResponse(candidate1, message, isSuccess, HttpStatus.OK);
    }

    @GetMapping("/candidate")
    public ResponseEntity<Object> getCandidate(@RequestParam Integer id) {
        return Response.handleResponse(candidateService.findCandidate(id),
                "Successfully retrieved", true, HttpStatus.OK);
    }

    @DeleteMapping("/candidate/{id}")
    public ResponseEntity<Object> deleteCandidate(@PathVariable Integer id) {
        candidateService.deleteCandidate(id);
        return Response.handleResponse("Details successfully deleted", true, HttpStatus.OK);
    }

    @GetMapping(value = "/candidate-by-election/{electionId}")
    public List<Candidate> getAllCandidatesByElection(@PathVariable Integer electionId) {
        return candidateService.listByElections(electionId);
    }

    @GetMapping(value = "/candidate/states/{state}")
    public ResponseEntity<Object> fetchCandidatesByStates(@PathVariable StateEnum state) {
        List<Candidate> candidates = candidateService.fetchCandidatesByStates(state);
        return Response.handleResponse(candidates, "Successfully fetched", true, HttpStatus.OK);
    }

}
