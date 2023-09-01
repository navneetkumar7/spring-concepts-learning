package com.nt.springconcepts.security.authnandauthz.repository.repository;

import java.util.List;

import com.nt.springconcepts.security.authnandauthz.repository.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {
	
	List<Cards> findByCustomerId(int customerId);

}
