package com.nt.springconcepts.security.customauthenticationprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("api/v1/accounts/{account_id}")
    public String getAccountDetails(@PathVariable("account_id") String accountId) {
        return accountId + " details are: Test";
    }
}
