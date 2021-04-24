//package com.Ult.videoconf.security.impl;
//
//import com.Ult.videoconf.model.AppUser;
//import com.Ult.videoconf.model.UserAuthentication;
//import com.Ult.videoconf.security.TokenAuthenticationService;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.SignatureException;
//import io.jsonwebtoken.UnsupportedJwtException;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class JsonWebTokenAuthenticationService implements TokenAuthenticationService {
//
//    @Value("${jwt.security.secret.key}")
//    private String secretKey;
//
//    private static final String AUTH_HEADER_NAME = "Authorization";
//
//    private final UserDetailsService userDetailsService;
//
//    @Autowired
//    public JsonWebTokenAuthenticationService(final UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    public Authentication authenticate(final HttpServletRequest request) {
//        final String token = request.getHeader(AUTH_HEADER_NAME);
//        final Jws<Claims> tokenData = parseToken(token);
//        if (tokenData != null) {
//            AppUser user = getUserFromToken(tokenData);
//            if (user != null) {
//                return new UserAuthentication(user);
//            }
//        }
//        return null;
//    }
//
//    private Jws<Claims> parseToken(final String token) {
//        if (token != null) {
//            try {
//                return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//            } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
//                    | SignatureException | IllegalArgumentException e) {
//                return null;
//            }
//        }
//        return null;
//    }
//
//    private AppUser getUserFromToken(final Jws<Claims> tokenData) {
//        try {
//            return (AppUser) userDetailsService
//                    .loadUserByUsername(tokenData.getBody().get("username").toString());
//        } catch (UsernameNotFoundException e) {
//            throw new UserNotFoundException("User "
//                    + tokenData.getBody().get("username").toString() + " not found");
//        }
//    }
//}