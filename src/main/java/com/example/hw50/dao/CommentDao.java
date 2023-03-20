package com.example.hw50.dao;

import com.example.hw50.entity.Comment;
import com.example.hw50.entity.User;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class CommentDao extends BaseDao{
    public CommentDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE comments (" +
                "commentId SERIAL PRIMARY KEY, " +
                "commentText TEXT, " +
                "commentDate TEXT)");
    }
    public void saveAll(List<Comment> comments) {
        String sql = "INSERT INTO comments (commenttext, commentdate) " +
                "VALUES (?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, comments.get(i).getCommentText());
                ps.setString(2, String.valueOf(comments.get(i).getTimeOfComment()));
            }

            @Override
            public int getBatchSize() {
                return comments.size();
            }
        });
    }
    public void deleteAll() {
        String sql = "delete from comments";
        jdbcTemplate.update(sql);
    }
}
