package com.Ult.videoconf.controllers;

import com.Ult.videoconf.appUser.AppUser;
import com.Ult.videoconf.appUser.AppUserRepository;
import com.Ult.videoconf.registration.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    RegistrationService registrationService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(path = "/all")
    public ResponseEntity<List<AppUser>>  getAllUsers() {
        System.out.println("------  ok  ------");
        List<AppUser> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);

    }

//    @GetMapping("/User")
//    public ResponseEntity<List<AppUser>> getAllUsers(@RequestParam(required = false) String email) {

//        try {
//            List<AppUser> users = new ArrayList<AppUser>();
//
//            if (email == null)
//                userRepository.findAll().forEach(users::add);
//            else
//                userRepository.findByEmail(email).forEach(users::add);
//
//            if (users.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(users, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }

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
            AppUser _user = userRepository.save(new AppUser(user.getFirstName(),user.getLastName(),
                    user.getEmail(), user.getPassword(),user.getAppUserRole(), user.getJobTitle(),
                    user.getPhone(),user.getImageUrl()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
