package com.example.pre_study.service;

import com.example.pre_study.entity.Post;
import com.example.pre_study.repository.PostRepository;
import com.example.pre_study.service.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponse> getPosts() {
        final List<Post> posts = postRepository.findPostsOrderByPublishedAtDesc();

        return posts.stream()
                .map(PostResponse::fromEntity)
                .toList();
    }
}
