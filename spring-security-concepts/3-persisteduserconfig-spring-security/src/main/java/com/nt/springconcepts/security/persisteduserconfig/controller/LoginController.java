package com.nt.springconcepts.security.persisteduserconfig.controller;

import com.nt.springconcepts.security.persisteduserconfig.model.Customer;
import com.nt.springconcepts.security.persisteduserconfig.reposiotry.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register-user")
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
}
