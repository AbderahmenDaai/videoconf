package com.Ult.videoconf.registration;

import com.Ult.videoconf.appUser.AppUser;
import com.Ult.videoconf.appUser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    AppUserRepository userRepository;


    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

//    @GetMapping(path = "/Allusers")
//    public Object getAllUsers() {
//        System.out.println("------  ok  ------");
//        List<AppUser> users = userRepository.findAll();
//        return ResponseEntity.status(HttpStatus.OK).body(users);
//
//    }

//    @PostMapping(path = "/createUser")
//    public Object register() {
//        AppUser user = new AppUser();
//        user.setEmail("aaaaa@gmail.com");
//        user.setFirstName("Ahmed");
//        user.setLastName("Ahmed");
//        userRepository.save(user);
//
//        return ResponseEntity.status(HttpStatus.OK).body("create");
//    }

}