package com.Ult.videoconf.controllers;

import com.Ult.videoconf.model.AppUser;
import com.Ult.videoconf.security.JsonWebTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "api/v1/singup")
@AllArgsConstructor
public class SingupController {




    @RequestMapping(
            value = "/login",
            method = {RequestMethod.GET})
    public ResponseEntity<?> login(@RequestParam String mail, @RequestParam String password) {


        return ResponseEntity.status(HttpStatus.OK).body("login");

    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }



}
