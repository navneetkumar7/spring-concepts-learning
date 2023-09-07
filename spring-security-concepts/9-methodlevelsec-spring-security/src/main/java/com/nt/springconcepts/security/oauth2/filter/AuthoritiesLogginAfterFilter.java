package com.nt.springconcepts.security.oauth2.filter;


import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@Slf4j
public class AuthoritiesLogginAfterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null)
        {
            log.info("User {} is authenitcated and has authorities{}",authentication.getName(),authentication.getAuthorities().toString());
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
