package com.example.book_recommendation.auth;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.book_recommendation.auth.dto.JoinReqDTO;
import com.example.book_recommendation.auth.dto.JoinResDTO;
import com.example.book_recommendation.auth.dto.User;
import com.example.book_recommendation.exception.CustomException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final AuthRepository authRepository;
  
  // 회원가입
  @Transactional
  public JoinResDTO signup(JoinReqDTO request) throws Exception {

    // 아이디 중복 체크
    if (authRepository.existsByUsername(request.getUsername())) {
      throw new CustomException("중복아이디", "user-100", HttpStatus.BAD_REQUEST);
    }
    
    // User 엔티티 생성
    User user = User.signup(request.getUsername(), request.getPassword());

    // user 저장
    authRepository.save(user);

    // 반환
    return new JoinResDTO(user);
  }
}
