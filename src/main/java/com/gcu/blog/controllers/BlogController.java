package com.gcu.blog.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.gcu.blog.business.BlogBusinessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.blog.models.BlogModel;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogBusinessInterface blogService;

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String blogs(Model model)
    {
        // If user securely logged in, add to session data.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if(null == session.getAttribute("user"))
            {
                session.setAttribute("user", currentUserName);
            }
        }

        List<BlogModel> blogList = blogService.getBlog();

        model.addAttribute("title", "Blogs");
        model.addAttribute("blogList", blogList);

        return "blogs";
    }

    @GetMapping("/createBlog")
    public String addBlogs(Model model)
    {

        model.addAttribute("title", "Add New Blog");
        model.addAttribute("blogModel", new BlogModel());

        return "createBlog";
    }

    @GetMapping("/displayBlog/{id}")
    public String displayBlog(@PathVariable("id") int id, Model model)
    {

        BlogModel blog = blogService.getBlogById(id);


        model.addAttribute("title", "Display Blog");
        model.addAttribute("blogModel", blog);

        return "displayBlog";
    }

    @PostMapping("/doAddBlog")
    public String doAddBlog(@Valid BlogModel blogModel, BindingResult bindingResult, Model model)
    {
        // Check form data for errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Add Blog Form");
            return "createBlog";
        }

        blogService.addBlog(blogModel);

        List<BlogModel> blogList = blogService.getBlog();

        model.addAttribute("title", "Blog");
        model.addAttribute("blogList", blogList);

        return "blogs";
    }

    @PostMapping("/doDeleteBlog/{id}")
    public String doDeleteBlog(@PathVariable int id)
    {
        BlogModel blog = blogService.getBlogById(id);

        blogService.deleteBlog(blog);

        return "redirect:/blogs/";
    }

    @PostMapping("/updateBlog/{id}")
    public String updateBlog(@PathVariable int id, Model model) {

        BlogModel blog = blogService.getBlogById(id);

        model.addAttribute("blogModel", blog);

        return "updateBlog";
    }

    @PostMapping("/doUpdateBlog")
    public String doUpdateBlog(@Valid BlogModel blogModel, BindingResult bindingResult, Model model)
    {
        // Check form data for errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Edit Blog Form");
            return "createBlog";
        }

        blogService.updateBlog(blogModel);

        // Get list of all coffee products
        List<BlogModel> blogList = blogService.getBlog();

        model.addAttribute("title", "Blog");
        model.addAttribute("blogList", blogList);

        return "blogs";
    }





}
