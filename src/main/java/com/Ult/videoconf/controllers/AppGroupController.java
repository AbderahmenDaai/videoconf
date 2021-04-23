package com.Ult.videoconf.controllers;

import com.Ult.videoconf.model.AppGroup;
import com.Ult.videoconf.model.AppUser;
import com.Ult.videoconf.repositotry.AppGroupRepository;
import com.Ult.videoconf.repositotry.AppUserRepository;
import com.Ult.videoconf.model.Group;
import com.Ult.videoconf.security.impl.AppGroupServiceImpl;
import com.Ult.videoconf.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "group")
public class
AppGroupController {

    @Autowired
    AppGroupServiceImpl serv;

    @Autowired
    AppGroupRepository appGroupRepository;

    @Autowired
   AppUserRepository userRepository;

    @Autowired
    RequestService requestService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value= "/create")
    public String create(@RequestBody List<AppGroup> group) {
        logger.debug("Saving group.");
        serv.createGroup(group);
        return "Groupe records created.";
    }

    @PostMapping(value= "/createGroup")
    public String createGroup(@RequestBody List<AppGroup> group) {
        logger.debug("Saving group.");
        serv.createGroup(group);
        return "Groupe records created.";
    }

    @GetMapping(value= "/getall")
    public Collection<AppGroup> getAll() {
        logger.debug("Getting all groups.");
        return serv.getAllGroup();
    }

    @GetMapping(value= "/getbyid/{group-id}")
    public Group getById(@PathVariable(value= "group-id") String id) {
        logger.debug("Getting group with group-id= {}.", id);
        AppGroup appGroup = serv.findGroupById(id).get();
        Group group = new Group();
        group.setTheme(appGroup.getTheme());
        return group;

    }

    @PutMapping(value= "/update/{group-id}")
    public String update(@PathVariable(value= "group-id") String id, @RequestBody AppGroup g) {
        logger.debug("Updating group with group-id= {}.", id);

        g.setId(id);
        serv.updateGroup(g);
        return "Group record for group-id= " + id + " updated.";
    }

    @DeleteMapping(value= "/delete/{group-id}")
    public String delete(@PathVariable(value= "group-id") String id) {
        logger.debug("Deleting group with group-id= {}.", id);
        serv.deleteGroupById("id");
        return "Group record for group-id= " + id + " deleted.";
    }

    @DeleteMapping(value= "/deleteall")
    public String deleteAll() {

        logger.debug("Deleting all group.");
        serv.deleteAllGroup();
        return "All group records deleted.";
    }

    //TODO Request rejoider to group

    @PostMapping(value="/rejoidergroup")
    public void rejoiderGroup(@RequestParam String id_user , @RequestParam String id_group){
        Optional<AppUser> user = userRepository.findById(id_user);
        Optional<AppGroup> group = appGroupRepository.findById(id_group);
        if(user.isPresent()||group.isPresent()) {
            AppGroup group1 = group.get();
            AppUser user1 = user.get() ;
          String msg =  requestService.sendRejoinderGroup(user1, group1);

        }

    }

}
