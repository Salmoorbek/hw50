package com.example.hw50.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
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
