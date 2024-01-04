package com.asorg.votingsystem.controller;


import com.asorg.votingsystem.dto.UserLoginDto;
import com.asorg.votingsystem.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @PostMapping(value = "user/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserLoginDto userLoginDto) {
        LOG.info("User log in starting...");
        return Response.handleResponse(userLoginDto, "Successfully logged in",true, HttpStatus.OK);
    }

    @PostMapping(value = "user/logout")
    public ResponseEntity<Object> loginUser() {
        return Response.handleResponse("Successfully logged out", true, HttpStatus.OK);
    }
}
