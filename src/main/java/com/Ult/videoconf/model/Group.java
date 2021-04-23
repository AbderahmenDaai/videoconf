package com.Ult.videoconf.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Group {

    private String id;
    private String theme;
    private AppUser chefreunion;
    private List<AppUser> userList;
}
