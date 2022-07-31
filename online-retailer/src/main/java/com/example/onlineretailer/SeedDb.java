package com.example.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.update(
                "INSERT INTO product_suggestion(description, recommended_price, estimated_annual_sales) VALUES (?, ?, ?)",
                "Test 1", 15.0, 23.0);
    }
}
