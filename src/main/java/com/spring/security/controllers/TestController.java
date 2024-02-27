package com.spring.security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    // publik route öppen för alla
    @GetMapping("/all")
    public String allAccess() {
        return "Public content!";
    }

    // user, måste vara inloggad och minst user roll
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/user")
    public String userAccess() {
        return "User content!";
    }

    // mod, måste vara minst mod roll kan ej vara user
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/mod")
    public String modAccess() {
        return "Moderator content!";
    }

    // admin, kan endast vara admin
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin content!";
    }
}












