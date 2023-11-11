package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.enums.ElectionTypeEnum;
import com.asorg.votingsystem.enums.StateEnum;
import com.asorg.votingsystem.service.ElectionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ElectionDetailController {
    @Autowired
    private ElectionDetailService electionDetailService;

    @PostMapping("/electionDetail")
    public ElectionDetail addElectionDetail(@RequestBody ElectionDetail electionDetail) {
        electionDetailService.addElectionDetail(electionDetail);
        return electionDetail;
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

}
