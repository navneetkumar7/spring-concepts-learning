package com.nt.springconcepts.security.oauth2withkeycloak.repository;

import com.nt.springconcepts.security.oauth2withkeycloak.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByEmail(String email);

}
