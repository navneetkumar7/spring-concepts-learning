package com.nt.springconcepts.security.persisteduserconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @GetMapping("api/v1/accounts/{account_id}/cards")
    public String getCardDetails(@PathVariable("account_id") String accountId) {
        return "account:" + accountId + " have cards:1001,1003";
    }
}
