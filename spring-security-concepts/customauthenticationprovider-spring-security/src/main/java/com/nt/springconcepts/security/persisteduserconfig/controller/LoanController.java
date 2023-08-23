package com.nt.springconcepts.security.persisteduserconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @GetMapping("/api/v1/accounts/{account_id}/loans")
    public String getLoans(@PathVariable("account_id") String accountId) {
        return accountId + " having dummy loans:1,2,3";
    }
    @GetMapping("/api/v1/accounts/{account_id}/loans/{loan_id}")
    public String getLoanDetails(@PathVariable("account_id") String accountId, @PathVariable("loan_id") String loanId) {
        return accountId + "having loanId:"+loanId+" is of housing loan";
    }
}
