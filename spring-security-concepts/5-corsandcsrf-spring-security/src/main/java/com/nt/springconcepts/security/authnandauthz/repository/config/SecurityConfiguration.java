package com.nt.springconcepts.security.authnandauthz.repository.config;

import com.nt.springconcepts.security.authnandauthz.repository.filter.CsrfCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler= new CsrfTokenRequestAttributeHandler();
        csrfTokenRequestAttributeHandler.setCsrfRequestAttributeName("_csrf");

        return http
                //next 2 lines share JSESSIONID to Angular application
                .securityContext().requireExplicitSave(false)
                .and().sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .cors()
                .configurationSource((httpServletRequest)->{
                    CorsConfiguration corsConfiguration= new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                    corsConfiguration.setAllowCredentials(true);
                    corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                    corsConfiguration.setMaxAge(3600L);
                    return corsConfiguration;
                })
                .and()
                .csrf((csrf)->csrf.csrfTokenRequestHandler(csrfTokenRequestAttributeHandler)
                        .ignoringRequestMatchers("/api/v1/contacts", "/register")//KP:public end points that don't need csrf protection
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(
                        (authorize) -> authorize
                                .requestMatchers("/api/v1/customers/**", "/api/v1/users").authenticated()
                                .requestMatchers("/api/v1/contacts", "/register","/api/v1/notices").permitAll()
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
    /*@Bean
    public PasswordEncoder passwordencoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
