package com.nt.springconcepts.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SecurityController {
    @GetMapping("/login")
    public String login(){
        return "logged in without security";
    }
}
