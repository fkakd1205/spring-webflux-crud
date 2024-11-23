package com.example.spring_webflux.domain.user.controller;

import com.example.spring_webflux.domain.user.dto.UserReqDto;
import com.example.spring_webflux.domain.user.dto.UserResDto;
import com.example.spring_webflux.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public Mono<ResponseEntity<?>> createOne(@RequestBody UserReqDto reqDto) {
        return userService.createOne(reqDto.getName())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/all")
    public Mono<ResponseEntity<?>> searchAll() {
        return Mono.just(ResponseEntity.ok(userService.searchAll()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserResDto>> searchOne(@PathVariable Long id) {
        return userService.searchOne(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<UserResDto>> updateOne(@PathVariable Long id, @RequestBody UserReqDto reqDto) {
        return userService.updateOne(id, reqDto.getName())
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<UserResDto>> deleteOne(@PathVariable Long id) {
        return userService.deleteOne(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

}
