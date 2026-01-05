package com.example.book_recommendation.auth.dto;

import lombok.Getter;

@Getter
public class LoginResDTO {
  private Long id;
  private String username;

  public LoginResDTO(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
  }
}
