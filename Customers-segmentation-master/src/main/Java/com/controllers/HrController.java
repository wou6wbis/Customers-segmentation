package com.controllers;

import com.entities.Hr;
import com.services.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HrController {


    @Autowired
    private HrService hrService;

    @RequestMapping("/hr")
    public String hello() {
        return "HI Hr";
    }

    @RequestMapping("/hr/hrs")
    public List<Hr> getAllHrs() {

        return hrService.getAllAHrs();
    }


    @RequestMapping("manager/{id}")
    public Optional<Hr> getHr(@PathVariable String id) {
        return hrService.getHr(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/hr")
    public void addHr(@RequestBody Hr manager) {
        hrService.addHr(manager);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/hr/{id}")
    public void updateHr(@RequestBody Hr manager, @PathVariable String id) {
        hrService.updateHr(id, manager);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/hr/{id}")
    public void deleteHr(@PathVariable String id) {
        hrService.deleteHr(id);
    }

}
