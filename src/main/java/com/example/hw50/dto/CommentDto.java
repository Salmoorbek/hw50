package com.example.hw50.dto;

import com.example.hw50.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CommentDto {
    private int id;
    private String commentText;
    private LocalDateTime timeOfComment;

    public static CommentDto from(Comment comment){
        return builder()
                .id(comment.getId())
                .commentText(comment.getCommentText())
                .timeOfComment(comment.getTimeOfComment())
                .build();
    }
}
