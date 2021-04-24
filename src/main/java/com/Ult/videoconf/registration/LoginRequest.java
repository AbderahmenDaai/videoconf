package com.Ult.videoconf.registration;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @ NotBlank
    private String email;

    @NotBlank
    private String password;


}
