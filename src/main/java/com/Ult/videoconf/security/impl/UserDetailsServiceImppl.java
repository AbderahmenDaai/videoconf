package com.Ult.videoconf.security.impl;

import com.Ult.videoconf.model.AppUser;
import com.Ult.videoconf.repositotry.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImppl implements UserDetailsService {

    private final AppUserRepository userMongoRepository;

    @Autowired
    public UserDetailsServiceImppl(final AppUserRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final AppUser user = userMongoRepository.findByUsername(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User with username:" + username + " not found");
        }
    }
}