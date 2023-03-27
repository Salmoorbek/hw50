package com.example.hw50.dao;

import com.example.hw50.dto.CommentDto;
import com.example.hw50.entity.Comment;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class CommentDao extends BaseDao{
    public CommentDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE if not exists comments (" +
                "commentId SERIAL PRIMARY KEY, " +
                "publicationId SERIAL," +
                "commentText TEXT, " +
                "commentDate TEXT," +
                "FOREIGN KEY (publicationId) REFERENCES publications(publicationId))");
    }

    public void saveAll(List<Comment> comments) {
        String sql = "INSERT INTO comments (commenttext, commentdate, publicationId) " +
                "VALUES (?,?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, comments.get(i).getCommentText());
                ps.setString(2, String.valueOf(comments.get(i).getTimeOfComment()));
                ps.setInt(3, comments.get(i).getPublicationId());
            }

            @Override
            public int getBatchSize() {
                return comments.size();
            }
        });
    }

    public List<CommentDto> getAllComments() {
        String sql = "SELECT * FROM comments";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CommentDto.class));
    }

    public void deleteAll() {
        String sql = "delete from comments";
        jdbcTemplate.update(sql);
    }

    public void alterSequenceComment() {
        String sql = "alter sequence comments_commentid_seq restart with 1";
        jdbcTemplate.update(sql);
    }

    public void save(Comment comment) {
        String sql = "insert into comments (commenttext, commentdate) " +
                "values(?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, comment.getCommentText());
            ps.setString(2, String.valueOf(comment.getTimeOfComment()));
            return ps;
        });
    }
    public void deleteById(Long publicationId) {
        String sql = "delete from comments " +
                "where commentid = ?";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, publicationId);
            return ps;
        });
    }
}
