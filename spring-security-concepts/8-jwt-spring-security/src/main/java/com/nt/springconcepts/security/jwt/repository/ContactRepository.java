package com.nt.springconcepts.security.jwt.repository;

import com.nt.springconcepts.security.jwt.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
