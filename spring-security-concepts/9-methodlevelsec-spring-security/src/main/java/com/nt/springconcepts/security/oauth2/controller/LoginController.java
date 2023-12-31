package com.nt.springconcepts.security.oauth2.controller;

import com.nt.springconcepts.security.oauth2.model.Customer;
import com.nt.springconcepts.security.oauth2.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer)
    {
        Customer customerFromDB=null;
        ResponseEntity response=null;
        try {
            String hashPassword= passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPassword);
            customerFromDB=customerRepository.save(customer);
            if(customerFromDB.getId()>0)
            {
                response=ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("user registered");
            }
        }catch (Exception ex)
        {
            response=ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("exception occurred"+ex.getMessage());
        }
        return response;
    }
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
