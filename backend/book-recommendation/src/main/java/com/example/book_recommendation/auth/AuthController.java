package com.example.book_recommendation.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_recommendation.auth.dto.JoinReqDTO;
import com.example.book_recommendation.auth.dto.JoinResDTO;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  // 회원가입
  @PostMapping("/signup")
  public ResponseEntity<?> signUp(@RequestBody JoinReqDTO request) throws Exception {

    // 서비스로직
    JoinResDTO responseDTO = authService.signup(request);

    // 응답
    return ResponseEntity.ok(responseDTO);
  }
  
  // 로그인
  // 로그아웃
  
}
