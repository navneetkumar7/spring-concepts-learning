package com.nt.springconcepts.security.corsandcsrf.reposiotry;

import java.util.List;

import com.nt.springconcepts.security.corsandcsrf.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
