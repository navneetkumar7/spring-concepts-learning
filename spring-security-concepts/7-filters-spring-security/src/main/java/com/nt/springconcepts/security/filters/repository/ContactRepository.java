package com.nt.springconcepts.security.filters.repository;

import com.nt.springconcepts.security.filters.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
