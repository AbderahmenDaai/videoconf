package com.Ult.videoconf.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;


public interface TokenAuthenticationService {

    Authentication authenticate(HttpServletRequest request);
}