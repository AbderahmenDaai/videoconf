package com.Ult.videoconf.services;

import com.Ult.videoconf.model.AppGroup;
import com.Ult.videoconf.model.AppUser;
import com.Ult.videoconf.model.Request;
import com.Ult.videoconf.repositotry.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public String sendRejoinderGroup(AppUser user, AppGroup group){

        AppUser chef = group.getChefreunion();

        Request request = new Request();

        request.setGroupe(group);
        request.setReciver(chef);
        request.setSender(user);
        request.setTheme(group.getTheme());
        request.setIsconfirmed(false);
        request.setIsrejected(false);

        requestRepository.save(request);
     String message ="Request is send ";
     return message ;

    }

}
