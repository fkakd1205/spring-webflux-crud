package com.example.spring_webflux.domain.post.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Builder
@Getter
@Table("post")
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    private Long id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private Long views;
    private LocalDateTime createdAt;
    @Setter
    private Long categoryId;
    private Long userId;
}
