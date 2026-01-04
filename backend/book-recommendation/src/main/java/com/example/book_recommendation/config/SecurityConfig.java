package com.example.book_recommendation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
          // 1. CSRF 해제
          .csrf(csrf -> csrf.disable())
          // 2. 폼 로그인 및 기본 인증 해제 (로그인 폼 방지)
          .formLogin(form -> form.disable())
          .httpBasic(basic -> basic.disable())
          // 3. 모든 요청 허용
          .authorizeHttpRequests(auth -> auth
              .anyRequest().permitAll()
          );

      return http.build();
    }
}
