package com.example.jdbctemplatemultidatasourcedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JdbctemplateMultiDatasourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbctemplateMultiDatasourceDemoApplication.class, args);
    }

}
