package com.Ult.videoconf.model;

import com.Ult.videoconf.model.AppUser;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Document(collection = "groupe")

public class AppGroup  {

    @Id
    private String id;
    private String theme;

    private AppUser chefreunion;

    private List<AppUser> userList;


    public AppGroup(String theme, AppUser role, List<AppUser> paticipant) {
        this.theme = theme;
        this.chefreunion = role;
        this.userList = paticipant;
    }


}
