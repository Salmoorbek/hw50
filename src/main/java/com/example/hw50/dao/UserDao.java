package com.example.hw50.dao;

import com.example.hw50.dto.UserDto;
import com.example.hw50.entity.Comment;
import com.example.hw50.entity.User;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao extends BaseDao{
    public UserDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE if not exists users" +
                "(userId SERIAL PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "accName TEXT NOT NULL," +
                "password TEXT NOT NULL, " +
                "subscribers INTEGER, " +
                "publications INTEGER, " +
                "subscriptions INTEGER)");
    }
    public void saveAll(List<User> users) {
        String sql = "INSERT INTO users (name, email, accName, password, subscribers, publications, subscriptions ) " +
                "VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1,users.get(i).getName());
                ps.setString(2,users.get(i).getEmail());
                ps.setString(3,users.get(i).getAccName());
                ps.setString(4,users.get(i).getPassword());
                ps.setInt(5,users.get(i).getCountFollower());
                ps.setInt(6,users.get(i).getCountPublication());
                ps.setInt(7,users.get(i).getCountSubscription());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
    }
    public void deleteAll() {
        String sql = "delete from users";
        jdbcTemplate.update(sql);
    }

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
    public List<UserDto> login(String email, String password){
        String sql = "select * from users where email = ? and password = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserDto.class),email, password);
    }
    public void register(User user) {
        String sql = "insert into users (name, email,accname, password) " +
                "values(?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getAccName());
            ps.setString(4, user.getPassword());
            return ps;
        });
    }
}
