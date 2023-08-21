package com.nt.springconcepts.security.persisteduserconfig.reposiotry;

import com.nt.springconcepts.security.persisteduserconfig.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    // spring jpa concept: derived method name query
    List<Customer> findByEmail(String email);

}
