package com.example.pre_study.controller.request;

import com.example.pre_study.entity.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeletePostRequest {

    private Long postId;

    @NotNull
    private String username;

    @NotNull
    private String password;
}
