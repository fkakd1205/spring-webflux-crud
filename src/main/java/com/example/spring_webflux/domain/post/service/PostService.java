package com.example.spring_webflux.domain.post.service;

import com.example.spring_webflux.domain.post.dto.PostReqDto;
import com.example.spring_webflux.domain.post.dto.PostResDto;
import com.example.spring_webflux.domain.post.entity.PostEntity;
import com.example.spring_webflux.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Mono<PostResDto> createOne(PostReqDto reqDto) {
        return postRepository.save(PostEntity.builder()
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .views(0L)
                .createdAt(LocalDateTime.now())
                .categoryId(reqDto.getCategoryId())
                .userId(reqDto.getUserId())
                .build())
                .map(PostResDto::toDto);
    }

    public Flux<PostResDto> searchAll() {
        return postRepository.findAll()
                .map(PostResDto::toDto);
    }

    public Flux<PostResDto> searchListByKeyword(String keyword) {
        return postRepository.searchListByKeyword(keyword)
                .map(PostResDto::toDto);
    }

    public Mono<PostResDto> updateOne(Long id, PostReqDto reqDto) {
        return postRepository.findById(id)
                .flatMap(r -> {
                    r.setTitle(reqDto.getTitle());
                    r.setContent(reqDto.getContent());
                    r.setViews(reqDto.getViews());
                    r.setCategoryId(reqDto.getCategoryId());
                    return postRepository.save(r);
                })
                .map(PostResDto::toDto);
    }

    public Mono<Void> deleteOne(Long id) {
        return postRepository.deleteById(id);
    }
}
