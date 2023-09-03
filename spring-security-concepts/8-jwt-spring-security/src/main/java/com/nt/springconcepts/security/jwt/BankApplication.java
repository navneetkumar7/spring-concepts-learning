package com.nt.springconcepts.security.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@EnableWebSecurity(debug = true)
@SpringBootApplication
public class BankApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
}