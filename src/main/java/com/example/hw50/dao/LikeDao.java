package com.example.hw50.dao;

import com.example.hw50.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LikeDao {
    private final JdbcTemplate jdbcTemplate;

    public String userLikedPublication(int publicationId){
        String result = String.valueOf(getPublicationsLikes(publicationId));
        if(result.isEmpty()){
            return "есть лайк";
        }else return "нет лайка";
    }
    public Like getPublicationsLikes(int publicationId){
        String query = "SELECT * FROM \"likes\" WHERE publicationId = ? ";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Like.class), publicationId);
    }
}
