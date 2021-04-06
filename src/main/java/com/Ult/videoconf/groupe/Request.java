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

    public Request() {
    }

    public Request(String theme, AppUser sender, AppUser reciver, AppGroup groupe, boolean isconfirmed, boolean isrejected) {
        this.theme = theme;
        this.sender = sender;
        this.reciver = reciver;
        this.groupe = groupe;
        this.isconfirmed = isconfirmed;
        this.isrejected = isrejected;
    }
}
