package com.example.hw50.controller;

import com.example.hw50.dto.CommentDto;
import com.example.hw50.service.CommentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommentDto addComment(@RequestBody CommentDto commentDto){
        return commentService.addComment(commentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        if (commentService.deleteComment(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
