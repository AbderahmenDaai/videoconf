package com.Ult.videoconf.groupe;

import com.Ult.videoconf.appUser.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public String sendRejoinderGroup(AppUser user,AppGroup group){

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
