package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.dto.ElectionDetailDto;
import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.enums.ElectionTypeEnum;
import com.asorg.votingsystem.enums.StateEnum;
import com.asorg.votingsystem.service.ElectionDetailService;
import com.asorg.votingsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ElectionDetailController {
    @Autowired
    private ElectionDetailService electionDetailService;

    @PostMapping("/electionDetail")
    public ResponseEntity<Object> addElectionDetail(@RequestBody ElectionDetailDto electionDetail) {
        ElectionDetail el = electionDetailService.addElectionDetail(electionDetail);
        String message = "Successfully added";
        boolean isSuccess = true;
        if (el == null) {
            isSuccess = false;
            message = "Election Detail already exists!";
        }
        return Response.handleResponse(el, message, isSuccess, HttpStatus.OK);
    }

    @PutMapping("/electionDetail")
    public ResponseEntity<Object> editElectionDetail(@RequestBody ElectionDetailDto electionDetail) {
        ElectionDetail el = electionDetailService.editElectionDetail(electionDetail);
        String message = "Successfully updated";
        boolean isSuccess = true;
        if (el == null) {
            isSuccess = false;
            message = "Election Detail already exists!";
        }
        return Response.handleResponse(el, message, isSuccess, HttpStatus.OK);
    }

    @GetMapping("/electionDetail")
    public ElectionDetail findElectionDetail(@RequestParam Integer id) {
        return electionDetailService.findElectionDetail(id);
    }

    @GetMapping("/electionDetail/{state}")
    public List<ElectionDetail> electionList(@PathVariable String state) {
        return electionDetailService.electionDetailList(StateEnum.valueOf(state.toUpperCase()));
    }

    @GetMapping(value = "/states")
    public StateEnum[] states(){
        return StateEnum.values();
    }

    @GetMapping(value = "/election-types")
    public ElectionTypeEnum[] electionTypes() {
        return ElectionTypeEnum.values();
    }

    @DeleteMapping(value = "/electionDetail/{id}")
    public ResponseEntity<Object> deleteElection(@PathVariable Integer id) {
        electionDetailService.deleteElectionDetail(id);
        return Response.handleResponse("data successfully deleted", true, HttpStatus.OK);
    }

}
