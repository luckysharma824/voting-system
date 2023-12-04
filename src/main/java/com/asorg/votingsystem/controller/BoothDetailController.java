package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.entity.BoothDetail;
import com.asorg.votingsystem.service.BoothDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class BoothDetailController {
    @Autowired
    private BoothDetailService boothDetailService;

    @PostMapping("/booth")
    public BoothDetail addBoothDetail(@RequestBody BoothDetail boothDetail) {
        boothDetailService.addBooth(boothDetail);
        return boothDetail;
    }

    @GetMapping("/booth")
    public BoothDetail getBoothDetail(@RequestParam Integer id) {
        return boothDetailService.findBoothDetail(id);
    }

}
