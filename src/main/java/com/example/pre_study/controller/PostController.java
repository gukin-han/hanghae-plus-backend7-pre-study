package com.example.pre_study.controller;

import com.example.pre_study.controller.request.CreatePostRequest;
import com.example.pre_study.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/v1/posts")
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.ok(postService.getPost());
    }

    @PostMapping("/api/v1/posts")
    public ResponseEntity<?> createPost(@RequestBody CreatePostRequest request) {
        return ResponseEntity.ok(postService.createPost(request));
    }

    @GetMapping("/api/v1/posts/{postId}")
    public ResponseEntity<?> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }
}
