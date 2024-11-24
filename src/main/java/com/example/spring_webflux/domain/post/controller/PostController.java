package com.example.spring_webflux.domain.post.controller;

import com.example.spring_webflux.domain.post.dto.PostReqDto;
import com.example.spring_webflux.domain.post.dto.PostResDto;
import com.example.spring_webflux.domain.post.dto.PostSearchReqDto;
import com.example.spring_webflux.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public Mono<ResponseEntity<?>> createOne(@RequestBody PostReqDto reqdto) {
        return postService.createOne(reqdto)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/all")
    public Mono<ResponseEntity<?>> searchAll() {
        return Mono.just(ResponseEntity.ok(postService.searchAll()));
    }

    @GetMapping("")
    public Mono<ResponseEntity<?>> searchListByKeyword(@RequestParam(name = "keyword") PostSearchReqDto reqDto) {
        return Mono.just(ResponseEntity.ok(postService.searchListByKeyword(reqDto.keyword())));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<PostResDto>> updateOne(@PathVariable Long id, @RequestBody PostReqDto reqdto) {
        return postService.updateOne(id, reqdto)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<PostResDto>> deleteOne(@PathVariable Long id) {
        return postService.deleteOne(id)
                .then(Mono.just(ResponseEntity.noContent().build()));

    }
}
