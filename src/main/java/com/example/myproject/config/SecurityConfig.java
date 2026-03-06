package com.example.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable()) // 1. 先關掉隱形證件檢查
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/quiz/getAll", "/register", "/login").permitAll() // 2. 把你的路徑放進白名單
	            .anyRequest().authenticated()
	        );
	    return http.build();
	}
}
