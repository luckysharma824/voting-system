package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.service.ElectionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ElectionDetailController {
    @Autowired
    private ElectionDetailService electionDetailService;
    @PostMapping("/electionDetail")
    public ElectionDetail addElectionDetail(@RequestBody ElectionDetail electionDetail){
        electionDetailService.addElectionDetail(electionDetail);
        return electionDetail;
    }
    @GetMapping("/electionDetail")
    public ElectionDetail findElectionDetail(@RequestParam Integer id){
        return electionDetailService.findElectionDetail(id);
    }


}
