package com.example.hw50.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
public class Comment {
    private int id;
    private int publicationId;
    private String commentText;
    private LocalDateTime timeOfComment;

    public Comment(int id, int publicationId, String commentText, LocalDateTime timeOfComment) {
        this.id = id;
        this.publicationId = publicationId;
        this.commentText = commentText;
        this.timeOfComment = timeOfComment;
    }
}
