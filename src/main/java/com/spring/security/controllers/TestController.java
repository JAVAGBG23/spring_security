package com.spring.security.controllers;

import com.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    UserRepository userRepository;

    // publik end point
    // du behöver ej vara inloggad
    @GetMapping("/public")
    public String allAccess() {
        return "Public Content";
    }

    // user end point
    // du måste vara inloggad
    // alla roller som finns kommer åt den här resursen där gör vi preAuthorize med alla roller
    @GetMapping("/user")
    public String userAccess() {
        return "User Content";
    }

    // moderator end point
    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String modAccess() {
        return "Moderator Content";
    }

    // admin end point
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Content";
    }
}
