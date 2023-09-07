package com.nt.springconcepts.security.oauth2withkeycloak.controller;


import com.nt.springconcepts.security.oauth2withkeycloak.model.Accounts;
import com.nt.springconcepts.security.oauth2withkeycloak.model.Customer;
import com.nt.springconcepts.security.oauth2withkeycloak.repository.AccountsRepository;
import com.nt.springconcepts.security.oauth2withkeycloak.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/api/v1/accounts")
    public Accounts getAccountDetails(@RequestParam String emailId) {
        List<Customer> customer = customerRepository.findByEmail(emailId);
        if (!ObjectUtils.isEmpty(customer)) {
            return accountsRepository.findByCustomerId(customer.get(0).getId());
        }
        return null;

        }
    }
