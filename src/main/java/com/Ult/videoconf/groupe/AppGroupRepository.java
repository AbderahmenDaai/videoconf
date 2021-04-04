package com.Ult.videoconf.groupe;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface AppGroupRepository extends MongoRepository<AppGroup, String> {


 List<AppGroup> findAll();




}
