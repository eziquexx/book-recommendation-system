package com.example.book_recommendation.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_recommendation.auth.dto.LoginReqDTO;
import com.example.book_recommendation.auth.dto.LoginResDTO;
import com.example.book_recommendation.auth.dto.SignUpReqDTO;
import com.example.book_recommendation.auth.dto.SignUpResDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  // 회원가입
  @PostMapping("/signup")
  public ResponseEntity<?> signUp(@RequestBody SignUpReqDTO request) throws Exception {

    // 서비스로직
    SignUpResDTO responseDTO = authService.signup(request);

    // 응답
    return ResponseEntity.ok(responseDTO);
  }
  
  // 로그인
  @PostMapping("/login")
  public ResponseEntity<?> logIn(@RequestBody LoginReqDTO request) throws Exception {
      
    // 서비스로직
    LoginResDTO responseDTO = authService.login(request);
    
    // 응답
    return ResponseEntity.ok(responseDTO);
  }
  
  // 로그아웃
  
}
