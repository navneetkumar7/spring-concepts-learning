package com.nt.springconcepts.security.corsandcsrf.reposiotry;

import com.nt.springconcepts.security.corsandcsrf.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
