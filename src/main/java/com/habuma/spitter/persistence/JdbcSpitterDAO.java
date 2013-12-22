package com.habuma.spitter.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author ralvarado
 */
@Component
public class JdbcSpitterDAO implements SpitterDAO {

    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname, email, updatebyemail) "
            + "values (?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_SPITTER =
            "select id, username, fullname, password, email, updatebyemail "
            + "from spitter where id = ?";
    @Autowired
    SimpleJdbcTemplate jdbcTemplate;

    public SimpleJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER, spitter.getUsername(),
                spitter.getPassword(), spitter.getFullname(),
                spitter.getEmail(), spitter.isUpdateByEmail());
    }

    @Override
    public Spitter getSpitterById(Long id) {
        RowMapper<Spitter> rowMapper = new RowMapper<Spitter>() {
            @Override
            public Spitter mapRow(ResultSet rs, int i) throws SQLException {
                Long id = rs.getLong(1);
                String username = rs.getString(2);
                String fullname = rs.getString(3);
                String password = rs.getString(4);
                String email = rs.getString(5);
                Boolean updatebyemail = rs.getBoolean(6);
                Spitter spitter = new Spitter(id, username, fullname, 
                                              password,email, updatebyemail);
                return spitter;
            }
        };
        return jdbcTemplate.queryForObject(SQL_SELECT_SPITTER, rowMapper, id);
    }
}
