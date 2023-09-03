package com.nt.springconcepts.security.jwt.controller;

import com.nt.springconcepts.security.jwt.model.Cards;
import com.nt.springconcepts.security.jwt.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    private CardsRepository cardsRepository;
    @GetMapping("/api/v1/customers/{customer_id}/cards")
    public List<Cards> getCardDetails(@PathVariable("customer_id") int customerId) {
        return cardsRepository.findByCustomerId(customerId);
    }
}
