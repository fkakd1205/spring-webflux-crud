package com.example.spring_webflux.domain.category.controller;

import com.example.spring_webflux.domain.category.service.CategoryService;
import com.example.spring_webflux.domain.category.dto.CategoryReqDto;
import com.example.spring_webflux.domain.category.dto.CategoryResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("")
    public Mono<ResponseEntity<?>> createOne(@RequestBody CategoryReqDto reqDto) {
        return categoryService.createOne(reqDto.getName())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/all")
    public Mono<ResponseEntity<?>> searchAll() {
        return Mono.just(ResponseEntity.ok(categoryService.searchAll()));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CategoryResDto>> updateOne(@PathVariable Long id, @RequestBody CategoryReqDto reqDto) {
        // 200 or 404 return
        return categoryService.updateOne(id, reqDto.getName())
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<CategoryResDto>> deleteOne(@PathVariable Long id) {
        // 204 return
        return categoryService.deleteOne(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
