package com.nt.springconcepts.security.oauth2.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .oauth2Login()
                .and().build();
    }
/*    @Bean
    public ClientRegistrationRepository clientRepository(){
        ClientRegistration clientRegistration= clientRegistration();
        return new InMemoryClientRegistrationRepository(clientRegistration);
    }

    private ClientRegistration clientRegistration() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("87c3d6f4c034602f4b75")
                .clientSecret("a2804676a16d0c79e64d007e570779408a4506b6").build();
    }*/
}
