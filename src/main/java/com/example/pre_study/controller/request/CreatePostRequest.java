package com.example.pre_study.controller.request;

import com.example.pre_study.entity.Post;
import com.example.pre_study.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatePostRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private String username;

    @NotNull
    private String password;

    public Post toPostEntity(User user, LocalDateTime dateTime) {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .user(user)
                .publishedAt(dateTime)
                .build();
    }
}
