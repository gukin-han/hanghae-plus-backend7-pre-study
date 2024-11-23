package com.example.pre_study.controller;

import com.example.pre_study.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/v1/posts")
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }
}
