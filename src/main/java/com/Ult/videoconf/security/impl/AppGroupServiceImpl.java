package com.Ult.videoconf.security.impl;

import com.Ult.videoconf.model.AppGroup;
import com.Ult.videoconf.model.AppUser;
import com.Ult.videoconf.repositotry.AppGroupRepository;
import com.Ult.videoconf.repositotry.AppGroupService;
import com.Ult.videoconf.repositotry.AppUserRepository;
import com.Ult.videoconf.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AppGroupServiceImpl implements AppGroupService {

    @Autowired
    AppGroupRepository Groupe;

   @Autowired
    AppUserRepository appUserRepository;


    @Override
    public void createGroup(List<AppGroup> group) {
        Groupe.saveAll(group);
    }

    @Override
    public void createGroupe(List<AppGroup> group) {
        List<AppGroup> groups = new ArrayList<>();

        for (AppGroup g : group) {
            List<AppUser> users = new ArrayList<>();
            AppUser chefrenion = new AppUser();
            chefrenion = appUserRepository.findByEmail(g.getChefreunion().getEmail()).get();
            for (AppUser u : g.getUserList()) {
                users.add(appUserRepository.findByEmail(u.getEmail()).get());
            }
            g.setUserList(users);
            g.setChefreunion(chefrenion);
            groups.add(g);
            }
        Groupe.saveAll(groups);
    }

    @Override
    public Collection<AppGroup> getAllGroup() {
        List<Group> groups = new ArrayList<>();
        List<AppGroup> all = Groupe.findAll();

        for (AppGroup g : all) {

            Group groupe = new Group();
            groupe.setTheme(g.getTheme());
            groups.add(groupe);
        }
        return all;
    }


    @Override
    public Optional<AppGroup> findGroupById(String id) {
        return Groupe.findById(id);
    }

    @Override
    public void deleteGroupById(String id) {
        Groupe.deleteById(id);
    }


    @Override
    public void updateGroup(AppGroup grp) {
        Groupe.save(grp);
    }

    @Override
    public void deleteAllGroup() {
        Groupe.deleteAll();
    }

}
