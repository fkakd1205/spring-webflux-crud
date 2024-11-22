package com.example.spring_webflux.domain.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("user")
public class UserEntity {
    @Id
    private Long id;
    private String name;
    private LocalDateTime createdAt;
}
