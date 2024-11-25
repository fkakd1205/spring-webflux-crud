package com.example.spring_webflux.domain.category.service;

import com.example.spring_webflux.domain.category.entity.CategoryEntity;
import com.example.spring_webflux.domain.category.repository.CategoryRepository;
import com.example.spring_webflux.domain.category.dto.CategoryResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Mono<CategoryResDto> createOne(String name) {
        return categoryRepository.save(CategoryEntity.builder().name(name).build())
                .map(CategoryResDto::toDto);
    }

    public Flux<CategoryResDto> searchAll() {
        return categoryRepository.findAll()
                .map(CategoryResDto::toDto);
    }

    public Mono<CategoryResDto> updateOne(Long id, String name) {
        return categoryRepository.findById(id)
                .flatMap(r -> {
                    r.setName(name);
                    return categoryRepository.save(r);
                })
                .map(CategoryResDto::toDto);
    }

    public Mono<Void> deleteOne(Long id) {
        return categoryRepository.deleteById(id);
    }
}