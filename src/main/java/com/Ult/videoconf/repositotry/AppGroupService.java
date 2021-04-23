package com.Ult.videoconf.repositotry;

import com.Ult.videoconf.model.AppGroup;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AppGroupService {

    void createGroup(List<AppGroup> group);

    public void createGroupe(List<AppGroup> group);

    Collection<AppGroup> getAllGroup();

    Optional<AppGroup> findGroupById(String id);

    void deleteGroupById(String id);

    void updateGroup(AppGroup grp);

    void deleteAllGroup();
}
