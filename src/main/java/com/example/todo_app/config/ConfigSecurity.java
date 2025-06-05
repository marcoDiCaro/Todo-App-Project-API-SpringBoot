package com.example.todo_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSecurity {
        @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // Consente accesso libero a /hello
                        .anyRequest().authenticated() // Tutto il resto richiede login
                )
                .formLogin().and() // Abilita il form di login
                .csrf().disable(); // Disabilita CSRF (utile per test/REST)
        return http.build();
    }
}