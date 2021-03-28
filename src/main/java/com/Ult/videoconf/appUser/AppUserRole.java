package com.Ult.videoconf.appUser;


import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "role")
public enum AppUserRole{
    ChefReunion,
    Participant;
    }

