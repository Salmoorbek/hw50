package com.example.hw50.dao;

import com.example.hw50.entity.Publication;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PublicationDao {
    private final JdbcTemplate jdbcTemplate;

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
