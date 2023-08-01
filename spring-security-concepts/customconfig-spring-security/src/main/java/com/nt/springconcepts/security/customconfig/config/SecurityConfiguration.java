package com.nt.springconcepts.security.customconfig.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        requests -> requests
                                .requestMatchers("/api/v1/accounts/**").authenticated()
                                .requestMatchers("/api/v1/contacts").permitAll()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();
/**
 * deny all requests
 */
     /*   return http.authorizeHttpRequests(request -> request.anyRequest().denyAll())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();*/

        /**
         * allow all requests
         */
     /*   return http.authorizeHttpRequests(request -> request.anyRequest().permitAll())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();*/
    }
}
