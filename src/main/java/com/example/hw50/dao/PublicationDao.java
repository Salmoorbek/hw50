package com.example.hw50.dao;

import com.example.hw50.entity.Publication;
import com.example.hw50.entity.User;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class PublicationDao extends BaseDao{
    public PublicationDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE publications (" +
                "publicationId SERIAL PRIMARY KEY, " +
                "userId INTEGER, " +
                "image TEXT, " +
                "description TEXT, " +
                "publicationDate TEXT, " +
                "FOREIGN KEY (userId) REFERENCES users(userId))");

    }
    public void saveAll(List<Publication> publications) {
        String sql = "INSERT INTO publications (userId, image, description, publicationDate)" +
                "VALUES (?,?,?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, publications.get(i).getId());
                ps.setString(2, publications.get(i).getImg());
                ps.setString(3, publications.get(i).getDescription());
                ps.setString(4, String.valueOf(publications.get(i).getTimeOfPublication()));
            }

            @Override
            public int getBatchSize() {
                return publications.size();
            }
        });
    }
    public void deleteAll() {
        String sql = "delete from publications";
        jdbcTemplate.update(sql);
    }

    public List<Publication> getPublicationsForUser(int userId){
        String query = "select * from \"publications\" " +
                "where userId != ?;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Publication.class), userId);
    }

    public List<Publication> getPublicationsForUserBySubscriptions(int userId){
        String query = "select\n" +
                "    p.image,\n" +
                "    p.description,\n" +
                "    p.publicationdate,\n" +
                "    s.subscribedto\n" +
                "    from \"publications\" as p\n" +
                "inner join \"users\" as u\n" +
                "on u.userid = p.userid\n" +
                "inner join \"subscriptions\" as s\n" +
                "on s.subscribedto = u.userid\n" +
                "where u.userid = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Publication.class), userId);
    }
}
