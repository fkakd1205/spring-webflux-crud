package com.example.spring_webflux.domain.dto;

import com.example.spring_webflux.domain.category.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResDto {
    String name;

    public static CategoryResDto toDto(CategoryEntity entity) {
        return CategoryResDto.builder()
                .name(entity.getName())
                .build();
    }
}
