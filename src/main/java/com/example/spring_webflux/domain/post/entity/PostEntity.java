package com.example.spring_webflux.domain.post.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("post")
public class PostEntity {
    @Id
    private Long id;
    private String title;
    private String content;
    private Long views;
    private LocalDateTime createdAt;
    private Long categoryId;
    private Long userId;
}
