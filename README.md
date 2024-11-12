# hanghae-plus-backend7-pre-study

항해플러스 백엔드 7기 - 사전스터디 (프레임워크)

<br/>

## 과제 요구사항

### 요약

- 1주차 - 프로젝트 테크 스펙 작성 및 요구사항 분석
- 2주차 - CRUD 구현
- 3주차 - 회원가입 / 로그인 기능 구현
- 4주차 - AWS 배포

## 개발 환경

- Language
    - Java 21
- Framework
    - SpringBoot 3.3.5
- Build Tool
    - Gradle
- DB
    - MySQL
- IDE
    - IntelliJ
- Test
    - Postman
    - Swagger
    - JUnit
    - AssertJ

## ERD

![image](https://github.com/user-attachments/assets/b5041d58-fd9d-40f8-9743-b3a0a2219ccb)



<br/>

## API 명세서

### AUTH

| 기능   | Method | URL                     | 비고 |
|------|--------|-------------------------|----|
| 회원가입 | POST   | `/api/v1/auth/register` |    |
| 로그인  | POST   | `/api/v1/auth/login`    |    |
| 로그아웃 | POST   | `/api/v1/auth/logout`   |    |
| 회원탈퇴 | DELETE | `/api/v1/auth/delete`   |    |

### POSTS

| 기능        | Method | URL                      | 비고        |
|-----------|--------|--------------------------|-----------|
| 게시글 작성    | POST   | `/api/v1/posts`          |           |
| 특정 게시글 조회 | GET    | `/api/v1/posts/{postId}` |           |
| 모든 게시글 조회 | GET    | `/api/v1/posts`          | Pageable  |
| 게시글 수정    | PATCH  | `/api/v1/posts/{postId}` | 수정 필드만 전달 |
| 게시글 삭제    | DELETE | `/api/v1/posts/{postId}` |           |

### COMMENTS

| 기능              | Method | URL                                            | 비고        |
|-----------------|--------|------------------------------------------------|-----------|
| 댓글 작성           | POST   | `/api/v1/posts/{postId}/comments`              |           |
| 특정 게시글 모든 댓글 조회 | GET    | `/api/v1/posts/{postId}/comments`              | Pageable  |
| 특정 댓글 조회        | GET    | `/api/v1/posts/{postId}/comments/{commentId}`  |           |
| 댓글 수정           | PATCH  | `/api/v1/posts/{postId}/comments/{commentId}`  | 수정 필드만 전달 |
| 댓글 삭제           | DELETE | `/api/v1/posts/{postId}/comments/{commentId}}` |           |

## 참고

- [API 문서작성 툴 고르기 | 이민재 (2022)](https://learnote-dev.com/java/Spring-A-%EB%AC%B8%EC%84%9C-%EC%9E%91%EC%84%B1%ED%95%98%EA%B8%B0/) 
