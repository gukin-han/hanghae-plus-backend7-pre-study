package com.example.pre_study.service.response;

import com.example.pre_study.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserResponse {

    private String username;

    @Builder
    private UserResponse(String username) {
        this.username = username;
    }

    public static UserResponse fromEntity(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .build();
    }

}
