package com.roganov.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v1/**").hasAnyRole("USER")
                .antMatchers("/api/v1/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/v1/api-docs/**","/swagger-ui/**", "/swagger-ui.html").permitAll()
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll();
    }

    @Bean
    protected TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }
}