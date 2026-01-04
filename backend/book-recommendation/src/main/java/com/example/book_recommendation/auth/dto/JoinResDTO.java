package com.example.book_recommendation.auth.dto;

import lombok.Getter;

@Getter
public class JoinResDTO {
  private Long id;
  private String username;

  public JoinResDTO(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
  }
}
