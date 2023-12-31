package com.nt.springconcepts.security.authnandauthz.repository.controller;

import com.nt.springconcepts.security.authnandauthz.repository.model.AccountTransactions;
import com.nt.springconcepts.security.authnandauthz.repository.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;
    @GetMapping("/api/v1/customers/{customer_id}/transactions")
    public List<AccountTransactions> getBalanceDetails(@PathVariable("customer_id") int customerId) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customerId);
    }
}
