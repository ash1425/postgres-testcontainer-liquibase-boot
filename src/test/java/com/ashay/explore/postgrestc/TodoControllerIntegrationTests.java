package com.ashay.explore.postgrestc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

import java.net.URI;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class TodoControllerIntegrationTests extends BaseIntegrationTests {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        jdbcTemplate.execute("truncate table todo;");
        jdbcTemplate.update("insert into todo(id, description) values (?, ?)", System.currentTimeMillis(), "test todo message");
    }

    @AfterEach
    public void tearDown() {
        super.jdbcTemplate.execute("truncate table todo;");
    }

    @Test
    void shouldGetAllTodo() {
        when()
                .get(URI.create("http://localhost:" + port + "/todo"))
                .prettyPeek()
                .then()
                .body("[0].description", equalTo("test todo message"));
    }
}
