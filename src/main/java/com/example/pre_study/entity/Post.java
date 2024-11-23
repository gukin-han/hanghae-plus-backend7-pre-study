package com.example.pre_study.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "posts")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String Title;

    @Column(nullable = false)
    private String content;

    private LocalDateTime publishedAt;

    @Builder
    private Post(Long postId, User user, String title, String content, LocalDateTime publishedAt) {
        this.postId = postId;
        this.user = user;
        Title = title;
        this.content = content;
        this.publishedAt = publishedAt;
    }
}
