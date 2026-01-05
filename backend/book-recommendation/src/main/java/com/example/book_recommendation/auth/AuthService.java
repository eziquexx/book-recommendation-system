package com.example.book_recommendation.auth;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.book_recommendation.auth.dto.LoginReqDTO;
import com.example.book_recommendation.auth.dto.LoginResDTO;
import com.example.book_recommendation.auth.dto.SignUpReqDTO;
import com.example.book_recommendation.auth.dto.SignUpResDTO;
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
  public SignUpResDTO signup(SignUpReqDTO request) throws Exception {

    // 아이디 중복 체크
    if (authRepository.existsByUsername(request.getUsername())) {
      throw new CustomException("중복아이디", "user-100", HttpStatus.BAD_REQUEST);
    }
    
    // User 엔티티 생성
    User user = User.signup(request.getUsername(), request.getPassword());

    // user 저장
    authRepository.save(user);

    // 반환
    return new SignUpResDTO(user);
  }

  // 로그인
  @Transactional
  public LoginResDTO login(LoginReqDTO request) throws Exception {

    User user = authRepository.findByUsername(request.getUsername());

    // 유효성 검사
    if (user == null) {
        throw new CustomException("유효하지 않은 아이디입니다.", "user-101", HttpStatus.BAD_REQUEST);
    }

    // 비밀번호 검사
    if (!request.getPassword().equals(user.getPassword())) {
        throw new CustomException("비밀번호 틀립니다.", "user-102", HttpStatus.BAD_REQUEST);
    }

    return new LoginResDTO(user);
  }
}
