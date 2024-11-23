package com.example.spring_webflux.domain.user.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Builder
@Table("user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private Long id;
    @Setter
    private String name;
    private LocalDateTime createdAt;
    @Setter
    private LocalDateTime updatedAt;
}
