package com.asorg.votingsystem.service;


import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class GreetingService {

    public String greeting() {
        return "Hello world! " + "Current time: " + Instant.now();
    }

    public String hMessage(String msg) {
        return msg;
    }

    public String userMsg(String name) {
        return "Hello " + name + "! this message is for you";
    }

}
