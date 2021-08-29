package com.example.blog.repository;

import com.example.model.Post;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PostRepository extends ReactiveCrudRepository<Post, Long> {

}