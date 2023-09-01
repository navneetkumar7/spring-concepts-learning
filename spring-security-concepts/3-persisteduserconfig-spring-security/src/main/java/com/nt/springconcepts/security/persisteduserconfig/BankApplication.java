package com.nt.springconcepts.security.persisteduserconfig;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.nt.springconcepts.security.persisteduserconfig.reposiotry")// this is needed if the repository package lies out sie of the package where main class is defined.
//@EntityScan("com.nt.springconcepts.security.persisteduserconfig.model")// needed only if package out side main class package.
public class BankApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
}