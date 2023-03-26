package com.example.hw50.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class BaseDao {

    protected final JdbcTemplate jdbcTemplate;

    public abstract void createTable();

}
