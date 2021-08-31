package com.example.blog.repository;

import com.example.model.Post;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ReactiveCrudRepository<Post, Long> {

}