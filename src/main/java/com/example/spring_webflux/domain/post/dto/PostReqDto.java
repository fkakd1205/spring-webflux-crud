package com.example.spring_webflux.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostReqDto {
    String title;
    String content;
    Long views;
    LocalDateTime createdAt;
    Long categoryId;
    Long userId;
}
