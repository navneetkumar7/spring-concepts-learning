package com.nt.springconcepts.security.authnandauthz.repository.repository;

import java.util.List;

import com.nt.springconcepts.security.authnandauthz.repository.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByEmail(String email);

}
