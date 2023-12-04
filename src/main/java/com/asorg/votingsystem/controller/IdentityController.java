package com.asorg.votingsystem.controller;

import com.asorg.votingsystem.entity.Identity;
import com.asorg.votingsystem.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class IdentityController {
    @Autowired
    private IdentityService identityService;
    @PostMapping("/identity")
    public Identity addIdentity(@RequestBody Identity identity){
        identityService.addIdentity(identity);
        return identity;

    }
    @GetMapping("/identity")
    public Identity getIdentity(@RequestParam Integer id) {
      return   identityService.findIdentity(id);

    }

}
