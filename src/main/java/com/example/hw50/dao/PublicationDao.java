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
        String query = "select " +
                "p.image, " +
                "p.description, " +
                "p.datetime, " +
                "s.subscribeuserid" +
                "from \"publications\" as p " +
                "inner join \"users\" as u " +
                "on u.id = p.userid " +
                "inner join \"subscriptions\" as s " +
                "on s.subscribeduserid = u.id " +
                "where u.id = ?;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Publication.class), userId);
    }
}
