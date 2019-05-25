package com.controllers;

import com.entities.Manager;
import com.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ManagerController {


    @Autowired
    private ManagerService managerService;

    @RequestMapping("/manager")
    public String hello() {
        return "HI Manager";
    }

    @RequestMapping("/manager/managers")
    public List<Manager> getAllManagers() {

        return managerService.getAllAManagers();
    }


    @RequestMapping("manager/{id}")
    public Optional<Manager> getManager(@PathVariable String id) {
        return managerService.getManager(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/manager")
    public void addManager(@RequestBody Manager manager) {
        managerService.addManager(manager);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/manager/{id}")
    public void updateManager(@RequestBody Manager manager, @PathVariable String id) {
        managerService.updateManager(id, manager);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/manager/{id}")
    public void deleteManager(@PathVariable String id) {
        managerService.deleteManager(id);
    }

}
