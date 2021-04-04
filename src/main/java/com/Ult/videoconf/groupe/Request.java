package com.Ult.videoconf.groupe;

import com.Ult.videoconf.appUser.AppUser;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "request")
public class Request {

    @Id
    private String id;
    private String theme;
    private AppUser sender;
    private AppUser reciver;
    private AppGroup groupe;
    private  boolean isconfirmed;
    private boolean isrejected;
}
