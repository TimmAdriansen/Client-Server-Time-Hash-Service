package com.example.timehashapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimeHashApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeHashApiApplication.class, args);
    }

}
