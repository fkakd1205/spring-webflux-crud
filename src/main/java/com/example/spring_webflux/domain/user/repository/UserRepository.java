package com.example.spring_webflux.domain.user.repository;

import com.example.spring_webflux.domain.user.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {
}
