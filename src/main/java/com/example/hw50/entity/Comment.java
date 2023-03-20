package com.example.hw50.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
public class Comment {
    private int id;
    private String commentText;
    private LocalDateTime timeOfComment;

    public Comment(int id, String commentText, LocalDateTime timeOfComment) {
        this.id = id;
        this.commentText = commentText;
        this.timeOfComment = timeOfComment;
    }
}
