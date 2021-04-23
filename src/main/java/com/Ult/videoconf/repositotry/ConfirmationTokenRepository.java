package com.Ult.videoconf.repositotry;


import com.Ult.videoconf.model.ConfirmationToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepository
        extends
        MongoRepository<ConfirmationToken, String> {

    Optional<ConfirmationToken> findByToken(String token);

    @Transactional
    @Query("{_id: 606c4c044df08a450b50e161}, {$set: {Score:89}}")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}