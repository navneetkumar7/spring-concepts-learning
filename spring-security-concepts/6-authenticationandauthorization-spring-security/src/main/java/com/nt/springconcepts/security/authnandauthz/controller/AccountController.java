package com.nt.springconcepts.security.authnandauthz.controller;


import com.nt.springconcepts.security.authnandauthz.model.Accounts;
import com.nt.springconcepts.security.authnandauthz.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/api/v1/customers/{customer_id}/accounts")
    public Accounts getAccountDetails(@PathVariable("customer_id") int customerId) {
        return accountsRepository.findByCustomerId(customerId);

    }
}
