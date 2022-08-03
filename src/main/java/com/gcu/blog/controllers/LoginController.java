package com.gcu.blog.controllers;

import com.gcu.blog.BlogApplication;
import com.gcu.blog.models.LoginModel;
import org.apache.juli.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final static Logger logger = Logger.getLogger(BlogApplication.class);

    @GetMapping("/")
    public String display(Model model)
    {
        //Display Login Form
        model.addAttribute("title", "Login Form");

        logger.info("Inside the Display Method of the Login Controller");
        return "login";
    }

}
