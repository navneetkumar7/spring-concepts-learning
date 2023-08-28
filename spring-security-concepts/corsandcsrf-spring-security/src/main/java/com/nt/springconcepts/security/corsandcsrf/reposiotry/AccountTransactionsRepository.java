package com.nt.springconcepts.security.corsandcsrf.reposiotry;

import java.util.List;

import com.nt.springconcepts.security.corsandcsrf.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {
	
	List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
