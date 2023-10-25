package com.asorg.votingsystem.service;

import com.asorg.votingsystem.entity.Identity;
import com.asorg.votingsystem.repository.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {
    @Autowired
    private IdentityRepository identityRepository;
    public void addIdentity(Identity identity){
        identityRepository.save(identity);
    }
    public Identity findIdentity(Integer id){
      return   identityRepository.findById(id).orElse(null);

    }

}
