package com.nt.springconcepts.security.filters.controller;

import com.nt.springconcepts.security.filters.model.Contact;
import com.nt.springconcepts.security.filters.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;
    @PostMapping("/api/v1/contacts")
    public Contact saveInquiryContacts(@RequestBody Contact contact) {
        contact.setContactId("SR-"+Math.random());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }
}
