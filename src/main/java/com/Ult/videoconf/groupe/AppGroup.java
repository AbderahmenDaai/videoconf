package com.Ult.videoconf.groupe;

import com.Ult.videoconf.appUser.AppUser;
import com.Ult.videoconf.appUser.AppUserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
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
