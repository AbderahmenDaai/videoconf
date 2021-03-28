package com.Ult.videoconf.controllers;

import com.Ult.videoconf.appUser.AppUser;
import com.Ult.videoconf.appUser.AppUserRepository;
import com.Ult.videoconf.registration.RegistrationRequest;
import com.Ult.videoconf.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    AppUserRepository userRepository;
    private final RegistrationService registrationService;

    @GetMapping("/all")
    public Object getAllUsers() {
        System.out.println("------  ok  ------");
        List<AppUser> users=userRepository.findAll();

//
//        try {
//            List<AppUser> users = new ArrayList<AppUser>();
//
//            if (email == null)
//                userRepository.findAll().forEach(users::add);
//            else {
//                AppUser user = userRepository.findByEmail(email).get();
//                if(user != null)
//                    users.add(user);
//
//            }
//
//            if (users.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(users, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }




        return users;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable("id") String id) {

        Optional<AppUser> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/craet")
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user) {

        try {
            AppUser _user = userRepository.save(new AppUser(user.getFirstName(),user.getLastName(), user.getEmail(),
                                user.getPassword(),user.getAppUserRole(), user.getJobTitle(), user.getPhone(),user.getImageUrl()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
