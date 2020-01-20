package com.example.jdbctemplatemultidatasourcedemo.controller;

import com.example.jdbctemplatemultidatasourcedemo.pojo.User;
import com.example.jdbctemplatemultidatasourcedemo.pojo.UserProfile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private JdbcTemplate jdbcTemplateOne;
    private JdbcTemplate jdbcTemplateTwo;

    public HelloController(@Qualifier("jdbcTemplateOne") JdbcTemplate jdbcTemplateOne,
                           @Qualifier("jdbcTemplateTwo") JdbcTemplate jdbcTemplateTwo) {
        this.jdbcTemplateOne = jdbcTemplateOne;
        this.jdbcTemplateTwo = jdbcTemplateTwo;
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return jdbcTemplateOne.query("select * from user;", new BeanPropertyRowMapper<>(User.class));
    }

    @GetMapping("/userProfile")
    public List<UserProfile> getAllUserProfile() {
        return jdbcTemplateTwo.query("select * from user_profile", new BeanPropertyRowMapper<>(UserProfile.class));
    }
}
