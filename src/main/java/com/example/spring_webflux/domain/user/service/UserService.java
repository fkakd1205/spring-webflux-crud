package com.example.spring_webflux.domain.user.service;

import com.example.spring_webflux.domain.user.dto.UserResDto;
import com.example.spring_webflux.domain.user.entity.UserEntity;
import com.example.spring_webflux.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Mono<UserResDto> createOne(String name) {
        LocalDateTime now = LocalDateTime.now();
        return userRepository.save(UserEntity.builder()
                .name(name)
                .createdAt(now)
                .updatedAt(now)
                .build())
                .map(UserResDto::toDto);
    }

    public Flux<UserResDto> searchAll() {
        return userRepository.findAll()
                .map(UserResDto::toDto);
    }

    public Mono<UserResDto> searchOne(Long id) {
        return userRepository.findById(id)
                .map(UserResDto::toDto);
    }

    public Mono<UserResDto> updateOne(Long id, String name) {
        return userRepository.findById(id)
                .flatMap(r -> {
                    r.setName(name);
                    r.setUpdatedAt(LocalDateTime.now());
                    return userRepository.save(r);
                })
                .map(UserResDto::toDto);
    }

    public Mono<Void> deleteOne(Long id) {
        return userRepository.deleteById(id);
    }
}
