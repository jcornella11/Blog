package com.gcu.blog;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class BlogApplication {

    private static final Logger logger = LogManager.getLogger(BlogApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(BlogApplication.class, args);
    }

}
