package com.nt.springconcepts.security.oauth2withkeycloak.controller;

import com.nt.springconcepts.security.oauth2withkeycloak.model.AccountTransactions;
import com.nt.springconcepts.security.oauth2withkeycloak.model.Customer;
import com.nt.springconcepts.security.oauth2withkeycloak.repository.AccountTransactionsRepository;
import com.nt.springconcepts.security.oauth2withkeycloak.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/api/v1/transactions")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String emailId) {
        List<Customer> customer = customerRepository.findByEmail(emailId);
        if (!ObjectUtils.isEmpty(customer)) {
            return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customer.get(0).getId());
        }
        return null;
    }
}
