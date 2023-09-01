package com.nt.springconcepts.security.authnandauthz.repository.repository;

import java.util.List;

import com.nt.springconcepts.security.authnandauthz.repository.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {
	
	List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
