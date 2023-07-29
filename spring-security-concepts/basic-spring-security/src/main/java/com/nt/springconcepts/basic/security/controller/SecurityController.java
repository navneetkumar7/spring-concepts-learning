package com.nt.springconcepts.basic.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @GetMapping("/security/basic")
    public String login(){
        return "default password set";
    }
}
