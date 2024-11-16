package com.example.pre_study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }
}