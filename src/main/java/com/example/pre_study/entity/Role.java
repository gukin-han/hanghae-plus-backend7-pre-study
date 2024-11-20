package com.example.pre_study.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {

    USER("유저"),
    ADMIN("어드민");

    private final String text;
}
