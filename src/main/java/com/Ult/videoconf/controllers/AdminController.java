package com.Ult.videoconf.controllers;

import com.Ult.videoconf.appUser.AppUser;
import com.Ult.videoconf.appUser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AppUserRepository userRepository;

    @PutMapping("updateuser/")
    public AppUser UpdateUser (@RequestBody AppUser user){

        AppUser newuser = userRepository.save(user);

        return newuser;

    }



}
