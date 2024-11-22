package com.example.spring_webflux.domain.post.repository;

import com.example.spring_webflux.domain.post.entity.PostEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ReactiveCrudRepository<PostEntity, Long> {
}
