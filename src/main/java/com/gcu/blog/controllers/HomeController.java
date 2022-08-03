package com.gcu.blog.controllers;


import com.gcu.blog.BlogApplication;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final static Logger logger = Logger.getLogger(BlogApplication.class);

    @GetMapping("/")
    public String home()
    {
        logger.info("Inside the Home Method of the Home Controller");

        return "home";
    }

}
