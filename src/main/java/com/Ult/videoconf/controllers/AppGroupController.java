package com.Ult.videoconf.controllers;

import com.Ult.videoconf.groupe.AppGroup;
import com.Ult.videoconf.groupe.AppGroupServiceImpl;
import com.Ult.videoconf.groupe.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "group")
public class AppGroupController {

    @Autowired
    AppGroupServiceImpl serv;

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
        g.setId("id");
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
}
