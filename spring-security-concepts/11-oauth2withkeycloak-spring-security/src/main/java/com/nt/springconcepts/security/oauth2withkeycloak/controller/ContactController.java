package com.nt.springconcepts.security.oauth2withkeycloak.controller;

import com.nt.springconcepts.security.oauth2withkeycloak.model.Contact;
import com.nt.springconcepts.security.oauth2withkeycloak.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;
    @PostMapping("/api/v1/contacts")
    //@PreFilter("filterObject.contactName!='Test'") //NOTE: for filtering your input and out parameters has to be collection type
    @PostFilter("filterObject.contactName!='Test'")
    public List<Contact> saveInquiryContacts(@RequestBody List<Contact> contacts) {
        Contact contact=contacts.get(0);
        contact.setContactId("SR-"+Math.random());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return Arrays.asList(contactRepository.save(contact));
    }
}
