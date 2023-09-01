package com.nt.springconcepts.security.authnandauthz.repository.repository;

import java.util.List;

import com.nt.springconcepts.security.authnandauthz.repository.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
