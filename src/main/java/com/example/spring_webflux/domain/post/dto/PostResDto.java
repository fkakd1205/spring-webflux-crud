package com.example.spring_webflux.domain.post.dto;

import com.example.spring_webflux.domain.post.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResDto {
    String title;
    String content;
    Long views;
    LocalDateTime createdAt;
    Long categoryId;
    Long userId;

    public static PostResDto toDto(PostEntity entity) {
        return PostResDto.builder()
                .title(entity.getTitle())
                .content(entity.getContent())
                .views(entity.getViews())
                .createdAt(entity.getCreatedAt())
                .categoryId(entity.getCategoryId())
                .userId(entity.getUserId())
                .build();
    }
}
