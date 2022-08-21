package com.gcu.blog.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.blog.models.BlogModel;
import com.gcu.blog.models.BlogList;

@RestController
@RequestMapping("/service")
public class BlogRestService
{
    //update
    @Autowired
    private BlogBusinessInterface service;

    @GetMapping(path = "/getjson", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<BlogModel> getBlogsAsJson()
    {
        return service.getBlog();
    }

    @GetMapping(path = "/getxml", produces = { MediaType.APPLICATION_ATOM_XML_VALUE })
    public BlogList getOrdersAsXml()
    {
        BlogList list = new BlogList();
        list.setBlogs(service.getBlog());
        return list;
    }

    @GetMapping(path = "/getblog/{id}")
    public ResponseEntity<?> getBlog(@PathVariable("id") int id)
    {
        try
        {
            BlogModel blog = service.getBlogById(id);
            if (blog == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(blog, HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getAllBlogsJson", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllBlogsJson()
    {
        try
        {
            List<BlogModel> blogs = service.getBlog();
            if (blogs == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(blogs, HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getAllBlogsXml", produces = { MediaType.APPLICATION_ATOM_XML_VALUE})
    public ResponseEntity<?> getAllBlogsXml()
    {
        try
        {
            BlogList blogs = new BlogList();
            blogs.setBlogs(service.getBlog());
            if (blogs == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(blogs, HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
