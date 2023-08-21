package com.nt.springconcepts.security.persisteduserconfig.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests(
                        requests -> requests
                                .requestMatchers("/api/v1/accounts/**").authenticated()
                                .requestMatchers("/api/v1/contacts","/register").permitAll()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();
    }

  /*  @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        *//* Approach 1 creating user using withDefaultPasswordEncoder*//*
     *//* UserDetails admin= User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .authorities("admin")
                .build();
        UserDetails user=User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin,user);*//*

     *//* Approach 2 creating user using NoOpPasswordEncoder*//*

        UserDetails admin = User.withUsername("admin")
                .password("admin")
                .authorities("admin")
                .build();
        UserDetails user = User.withUsername("username")
                .password("user")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin, user);

    }*/

   /* @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    /**
     * NoOpPasswordEncoder
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordencoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
