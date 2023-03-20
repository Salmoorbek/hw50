package com.example.hw50.service;

import com.example.hw50.dao.CommentDao;
import com.example.hw50.dto.CommentDto;
import com.example.hw50.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentDao commentDao;

    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public CommentDto addComment(CommentDto commentDto) {
        var comment = Comment.builder()
                .commentText(commentDto.getCommentText())
                .timeOfComment(commentDto.getTimeOfComment())
                .build();

        commentDao.save(comment);
        return CommentDto.from(comment);
    }
    public boolean deleteComment(Long commentId) {
        //TODO recalculate movie rating before delete
        commentDao.deleteById(commentId);
        return true;
    }
}
