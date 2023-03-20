package com.example.hw50.dao;

import com.example.hw50.entity.Subscription;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class SubscriptionDao extends BaseDao{
    public SubscriptionDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE if not exists subscriptions (" +
                "id bigserial primary key," +
                "subscribes INTEGER, " +
                "subscribedTo INTEGER, " +
                "subscriptionDate TEXT," +
                "FOREIGN KEY (subscribes) REFERENCES users(userId), " +
                "FOREIGN KEY (subscribedTo) REFERENCES users(userId))");
    }
    public void saveAll(List<Subscription> subscriptions) {
        String sql = "INSERT INTO subscriptions (subscribes, subscribedTo, subscriptionDate) " +
                "VALUES (?,?,?,?) " ;
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1,subscriptions.get(i).getSubscribes());
                ps.setInt(2,subscriptions.get(i).getSubscribedTo());
                ps.setString(3, String.valueOf(subscriptions.get(i).getSubscribeTime()));
            }

            @Override
            public int getBatchSize() {
                return subscriptions.size();
            }
        });
    }
    public void deleteAll() {
        String sql = "delete from subscriptions";
        jdbcTemplate.update(sql);
    }

}
