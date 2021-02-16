package com.ashay.explore.postgrestc.repository;

import com.ashay.explore.postgrestc.dto.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Todo> getAll() {
        return jdbcTemplate.query("select * from todo", (rs, rowNum) ->
                new Todo(rs.getLong("id"), rs.getString("description"))
        );
    }
}
