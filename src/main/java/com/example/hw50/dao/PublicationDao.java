package com.example.hw50.dao;

import com.example.hw50.dto.PublicationDto;
import com.example.hw50.entity.Publication;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class PublicationDao extends BaseDao{
    public PublicationDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }
    private Connection conn;

    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE if not exists publications (" +
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

    public void alertSequencePublication() {
        String sql = "alter sequence publications_publicationid_seq restart with 1";
        jdbcTemplate.update(sql);
    }

    public List<Publication> getPublicationsForUser(int userId) {
        String query = "select * from \"publications\" " +
                "where userId != ?;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Publication.class), userId);
    }

    public List<Publication> getPublicationsForUserBySubscriptions(int userId) {
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
    public void save(Publication publication) {
        String sql = "insert into publications (image, description, publicationdate) " +
                "values(?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, publication.getImg());
            ps.setString(2, publication.getDescription());
            ps.setString(3, String.valueOf(publication.getTimeOfPublication()));
            return ps;
        });
    }

    public void deleteById(Long publicationId) {
        String sql = "delete from publications " +
                "where publicationid = ?";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, publicationId);
            return ps;
        });
    }

    public List<Publication> getAllPubs() {
        String sql = "SELECT * FROM publications";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Publication.class));
    }
}
