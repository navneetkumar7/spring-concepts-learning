package com.nt.springconcepts.security.authnandauthz.repository.controller;

import com.nt.springconcepts.security.authnandauthz.repository.model.Loans;
import com.nt.springconcepts.security.authnandauthz.repository.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {
    @Autowired
    private LoanRepository loanRepository;
    @GetMapping("/api/v1/customers/{customer_id}/loans")
    public List<Loans> getLoans(@PathVariable("customer_id") int customerId) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }

}
