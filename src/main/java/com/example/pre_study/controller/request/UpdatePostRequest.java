package com.example.pre_study.controller.request;

import com.example.pre_study.entity.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdatePostRequest {

    private Long postId;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private String username;

    @NotNull
    private String password;
}
