package com.Ult.videoconf.groupe;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Notification")
public class Notification {

    @Id
    private String id;
    private String theme;
    private Request request;
    private LocalDateTime createdAt;
    private LocalDateTime confirmedAt;

    public Notification(String theme, Request request, LocalDateTime createdAt, LocalDateTime confirmedAt) {
        this.theme = theme;
        this.request = request;
        this.createdAt = createdAt;
        this.confirmedAt = confirmedAt;
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

