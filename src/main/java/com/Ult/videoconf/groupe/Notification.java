package com.Ult.videoconf.groupe;

import com.Ult.videoconf.appUser.AppUser;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Notification")
public class Notification {

    @Id
    private String id;
    private String theme;
    private Request request;

    public Notification(String theme, Request request) {
        this.theme = theme;
        this.request = request;
    }
}
//joinder group api/creart demande
//body appuser appgroup
//==> creation demande
//sender appuser
//rever chefgroup
//creation of notification
//notification theme rquest
//api gert notification byuser
//confirmation or reject notific by user
//api chefruenion is confifimed appuser ==> add user to group
//

