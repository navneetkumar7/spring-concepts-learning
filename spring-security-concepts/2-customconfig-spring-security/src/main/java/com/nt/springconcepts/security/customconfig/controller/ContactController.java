package com.nt.springconcepts.security.customconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("api/v1/contacts")

    public String getContacts() {
        return "contact us at 000111";
    }
}
