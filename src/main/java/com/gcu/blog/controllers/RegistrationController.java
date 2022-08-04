package com.gcu.blog.controllers;

import com.gcu.blog.BlogApplication;
import com.gcu.blog.business.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gcu.blog.models.UserModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    private static final Logger logger = LogManager.getLogger(RegistrationController.class);

    @Autowired
    UserBusinessService service;

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("title", "Register");
        model.addAttribute("userModel", new UserModel());

        logger.info("Inside the Register Method of the Registration Controller");

        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model)
    {
        // Check form data for errors
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Register");
            return "register";
        }

        //Encode Password
        String encoded = new BCryptPasswordEncoder().encode(userModel.getPassword());

        // Add encoded password to UserModel
        userModel.setPassword(encoded);

        // Get user service and add new user
        service.addUser(userModel);

        logger.info("Inside the doRegister Method of the Registration Controller");

        return "login";

    }


}
