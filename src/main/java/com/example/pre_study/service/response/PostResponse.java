package com.example.pre_study.service.response;

import com.example.pre_study.entity.Post;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {

    private Long postId;
    private UserResponse user;
    private String title;
    private String content;
    private boolean isPublished;
    private LocalDateTime publishedAt;

    @Builder
    private PostResponse(Long postId, UserResponse user, String title, String content, boolean isPublished, LocalDateTime publishedAt) {
        this.postId = postId;
        this.user = user;
        this.title = title;
        this.content = content;
        this.isPublished = isPublished;
        this.publishedAt = publishedAt;
    }

    public static PostResponse fromEntity(Post post) {
        final UserResponse userResponse = UserResponse.fromEntity(post.getUser());

        return PostResponse.builder()
                .postId(post.getPostId())
                .content(post.getContent())
                .title(post.getTitle())
                .publishedAt(post.getPublishedAt())
                .user(userResponse)
                .build();
    }
}
