package com.example.spring_webflux.domain.post.repository;

import com.example.spring_webflux.domain.post.entity.PostEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PostRepository extends ReactiveCrudRepository<PostEntity, Long> {
    @Query("SELECT * FROM post p WHERE p.title LIKE CONCAT('%', :keyword, '%') OR p.content LIKE CONCAT('%', :keyword, '%')")
    Flux<PostEntity> searchListByKeyword(@Param("keyword") String keyword);
}
