package com.nt.springconcepts.security.jwt.repository;

import com.nt.springconcepts.security.jwt.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
