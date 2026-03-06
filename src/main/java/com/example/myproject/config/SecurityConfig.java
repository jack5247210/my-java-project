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
            // 1. 必須明確啟用 CORS 支援，它會去抓取你的 WebMvcConfig 設定
            .cors(Customizer.withDefaults())
            
            // 2. 關閉 CSRF 防護（開發階段串接 API 通常先關閉，否則 POST 會被擋）
            .csrf(csrf -> csrf.disable())
            
            // 3. 設定哪些路徑需要登入，哪些不用
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/api/public/**").permitAll() // 允許登入介面不需驗證
                .anyRequest().authenticated() // 其他請求都需要登入
            );
            
            

        return http.build();
    }
}
