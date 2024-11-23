package com.example.spring_webflux.domain.user.dto;

import com.example.spring_webflux.domain.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResDto {
    String name;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public static UserResDto toDto(UserEntity entity) {
        return UserResDto.builder()
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
