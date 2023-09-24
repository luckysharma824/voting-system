package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = "/greetings")
    public String greeting() {
        return greetingService.greeting();
    }

    @GetMapping(value = "/message")
    public String helloMessage(@RequestParam String message) {
        return greetingService.hMessage(message);
    }

    @GetMapping(value = "/user/{name}/message")
    public String userMsg(@PathVariable String name) {
        return greetingService.userMsg(name);
    }
}
