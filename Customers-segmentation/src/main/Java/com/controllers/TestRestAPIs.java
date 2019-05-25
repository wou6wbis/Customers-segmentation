package com.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {


    @GetMapping("/test/manager")
    @PreAuthorize("hasRole('M')")
    public String projectManagementAccess() {
        return ">>> Manager Board";
    }

    @GetMapping("/test/hr")
    @PreAuthorize("hasRole('HR')")
    public String adminAccess() {
        return ">>> RH Contents";
    }
}
