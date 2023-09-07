package com.nt.springconcepts.security.oauth2withkeycloak.repository;


import com.nt.springconcepts.security.oauth2withkeycloak.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
