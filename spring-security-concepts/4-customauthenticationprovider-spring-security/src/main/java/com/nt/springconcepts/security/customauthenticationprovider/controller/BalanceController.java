package com.nt.springconcepts.security.customauthenticationprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/api/v1/accounts/{account_id}/balance")
    public String getBalanceDetails(@PathVariable("account_id") String accountId) {
        return accountId + " having dummy balance:$1Million";
    }
}
