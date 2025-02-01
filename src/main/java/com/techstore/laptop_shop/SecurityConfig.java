package com.techstore.laptop_shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Allow all requests
                )
                .csrf(csrf -> csrf.disable()) // Disable CSRF if needed for APIs
                .formLogin(login -> login.disable()) // Disable login form
                .httpBasic(basic -> basic.disable()); // Disable basic auth if needed
        return http.build();
    }

}