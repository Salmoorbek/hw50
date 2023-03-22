package com.example.hw50.dao;

import com.example.hw50.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public User findUsersByName(String name) {
        String query = "select * from \"users\"\n" +
                "         where name = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class), name);
    }

    public User findUserByAccountName(String accName) {
        String query = "select * from \"users\" where accName = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class), accName);
    }

    public User findUserByEmail(String email) {
        String query = "select * from \"users\" where email =?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class), email);
    }

    public String isRegisteredEmail(String email) {
        String result = String.valueOf(findUserByEmail(email));
        if (!result.isEmpty()) {
            return "Пользователь есть в системе";
        } else return "Пользователя нету в системе";
    }
}
