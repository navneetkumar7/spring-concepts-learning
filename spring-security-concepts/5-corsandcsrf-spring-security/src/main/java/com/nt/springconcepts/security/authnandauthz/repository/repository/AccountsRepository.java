package com.nt.springconcepts.security.authnandauthz.repository.repository;

import com.nt.springconcepts.security.authnandauthz.repository.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
