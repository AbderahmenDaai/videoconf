package com.Ult.videoconf.security;

public interface JsonWebTokenService {

    String getToken(String username, String password);

}