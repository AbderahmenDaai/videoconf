package com.Ult.videoconf.controllers;


import com.Ult.videoconf.appUser.AppUser;
import com.Ult.videoconf.appUser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "testUsers")
@AllArgsConstructor
public class TestUser {


    @Autowired
    AppUserRepository userRepository;

    @GetMapping(path = "/all")
    public ResponseEntity<List<AppUser>>  getAllUsers() {
        System.out.println("------  ok  ------");
        List<AppUser> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);

    }

    @PostMapping(path = "/createUser")
    public Object register() {
        AppUser user = new AppUser();
        user.setEmail("aaaaa@gmail.com");
        user.setFirstName("Ahmed");
        user.setLastName("Ahmed");
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body("create");
    }

}
