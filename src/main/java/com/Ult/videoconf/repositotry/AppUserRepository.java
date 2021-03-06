package com.Ult.videoconf.repositotry;

import com.Ult.videoconf.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends MongoRepository<AppUser, String> {

    Optional<AppUser> findByEmail(String email);



    @Transactional

    @Query("UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1" )
    int enableAppUser(String email);


    @Query("{username : ?0}")
    AppUser findByUsername(String username);




}