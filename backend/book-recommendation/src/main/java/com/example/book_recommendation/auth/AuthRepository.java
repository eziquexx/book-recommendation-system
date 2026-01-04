package com.example.book_recommendation.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book_recommendation.auth.dto.User;

public interface AuthRepository extends JpaRepository<User, Long> {
  
  // 아이디 중복 체크
  boolean existsByUsername(String username);
}
