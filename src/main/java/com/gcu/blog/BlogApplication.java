package com.gcu.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.apache.log4j.Logger;


@SpringBootApplication
public class BlogApplication {

    private final static Logger logger = Logger.getLogger(BlogApplication.class);

    public static void main(String[] args) {
        
        SpringApplication.run(BlogApplication.class, args);
    }

}
