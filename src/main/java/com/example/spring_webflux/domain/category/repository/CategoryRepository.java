package com.example.spring_webflux.domain.category.repository;

import com.example.spring_webflux.domain.category.entity.CategoryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<CategoryEntity, Long> {
}
