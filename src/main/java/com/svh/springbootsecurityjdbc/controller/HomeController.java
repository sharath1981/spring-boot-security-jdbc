package com.svh.springbootsecurityjdbc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public Map<Object, Object> home() {
        return getUserDetails();
    }

    private Map<Object, Object> getUserDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        var map = new HashMap<>();
        map.put(auth.getName(), auth.getAuthorities());
        return map;
    }

    @GetMapping("/admin")
    public Map<Object, Object> getAdmin() {
        return getUserDetails();
    }

    @GetMapping("/user")
    public Map<Object, Object> getUser() {
        return getUserDetails();
    }

}
