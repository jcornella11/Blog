package com.gcu.blog.controllers;

import com.gcu.blog.BlogApplication;
import com.gcu.blog.models.LoginModel;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @GetMapping("/")
    public String display(Model model)
    {
        //Display Login Form
        model.addAttribute("title", "Login Form");

        logger.info("Inside the Display Method of the Login Controller");
        return "login";
    }

}
