package com.nt.springconcepts.security.oauth2withkeycloak.controller;

import com.nt.springconcepts.security.oauth2withkeycloak.model.Customer;
import com.nt.springconcepts.security.oauth2withkeycloak.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/api/v1/users")
    public Customer getUserDetailsAfterLogin(Authentication authentication)
    {
        List<Customer>customers=customerRepository.findByEmail("jonh.doe@gmail.com");
        if(customers.size()>0)
            return customers.get(0);
        else
            return null;
    }
}
