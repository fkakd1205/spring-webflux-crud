package com.example.spring_webflux.domain.category.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder
@Table("category")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {
    @Id
    private Long id;
    @Setter
    private String name;
}
