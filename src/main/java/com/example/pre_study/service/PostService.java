package com.example.pre_study.service;

import com.example.pre_study.controller.request.CreatePostRequest;
import com.example.pre_study.controller.request.DeletePostRequest;
import com.example.pre_study.controller.request.UpdatePostRequest;
import com.example.pre_study.entity.Post;
import com.example.pre_study.entity.User;
import com.example.pre_study.repository.PostRepository;
import com.example.pre_study.repository.UserRepository;
import com.example.pre_study.service.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    public static final String ERROR_USER_NOT_FOUND = "유저를 조회할 수 없습니다.";
    public static final String ERROR_POST_NOT_FOUND = "게시글을 조회할 수 없습니다.";

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<PostResponse> getPost() {
        final List<Post> posts = postRepository.findPostsOrderByPublishedAtDesc();

        return posts.stream()
                .map(PostResponse::fromEntity)
                .toList();
    }

    public PostResponse createPost(CreatePostRequest request) {

        final User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException(ERROR_USER_NOT_FOUND));

        final Post post = request.toPostEntity(user, LocalDateTime.now());
        final Post savedPost = postRepository.save(post);

        return PostResponse.fromEntity(savedPost);
    }

    public PostResponse getPostById(Long postId) {
        final Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_POST_NOT_FOUND));
        return PostResponse.fromEntity(post);
    }

    @Transactional
    public void updatePost(UpdatePostRequest request) {
        final User user = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword())
                .orElseThrow(() -> new IllegalArgumentException(ERROR_USER_NOT_FOUND));
        final Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new IllegalArgumentException(ERROR_POST_NOT_FOUND));


        post.updatePost(request.getTitle(), request.getContent());
    }

    public void deletePost(DeletePostRequest request) {
        final User user = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword())
                .orElseThrow(() -> new IllegalArgumentException(ERROR_USER_NOT_FOUND));
        final Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new IllegalArgumentException(ERROR_POST_NOT_FOUND));

        postRepository.delete(post);
    }
}
