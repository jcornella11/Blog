package com.gcu.blog.controllers;


import com.gcu.blog.BlogApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class HomeController {

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @GetMapping("/")
    public String home()
    {
        logger.info("Inside the Home Method of the Home Controller");

        return "home";
    }

}
