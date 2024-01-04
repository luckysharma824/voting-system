package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.dto.BoothDetailDto;
import com.asorg.votingsystem.entity.BoothDetail;
import com.asorg.votingsystem.service.BoothDetailService;
import com.asorg.votingsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class BoothDetailController {
    @Autowired
    private BoothDetailService boothDetailService;

    @PostMapping("/booth")
    public ResponseEntity<Object> addBoothDetail(@RequestBody BoothDetailDto boothDetail) {
        BoothDetail detail = boothDetailService.addBooth(boothDetail);
        return Response.handleResponse(detail, "Successfully added", true, HttpStatus.OK);
    }

    @GetMapping("/booth")
    public BoothDetail getBoothDetail(@RequestParam Integer id) {
        return boothDetailService.findBoothDetail(id);
    }

}
