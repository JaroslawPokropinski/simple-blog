package com.example.blog.controller;

import java.util.stream.Stream;

import com.example.blog.repository.PostRepository;
import com.example.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/post")
public class PostController {

  private PostRepository postRepository;

  @Autowired
  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @GetMapping
  public Flux<Post> getAllPosts() {
    return this.postRepository.findAll();
  }

  @PostMapping
  public Flux<Post> postNewPost(@RequestBody Post post) {
    return this.postRepository.saveAll(Flux.fromStream(Stream.of(post)));
  }
}
