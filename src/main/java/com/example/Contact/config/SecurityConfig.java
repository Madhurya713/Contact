package com.example.Contact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normal = User.withUsername("Madhuya").password("Madhurya").roles("NORMAL").build();
        UserDetails admin = User.withUsername("Monal").password("Monal").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(normal, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeHttpRequests().
                requestMatchers("/api/contacts/**").permitAll().
                anyRequest().authenticated().and().formLogin();

        return httpSecurity.build();
    }
}
