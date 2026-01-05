package com.example.book_recommendation.auth.dto;

import lombok.Getter;

@Getter
public class SignUpResDTO {
  private Long id;
  private String username;

  public SignUpResDTO(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
  }
}
