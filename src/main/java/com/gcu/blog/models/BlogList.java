package com.gcu.blog.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="blogs")
public class BlogList {

    private List<BlogModel> blogs = new ArrayList<BlogModel>();

    @XmlElement(name="blog")
    public List<BlogModel> getBlogs()
    {
        return this.blogs;
    }

    public void setBlogs(List<BlogModel> blogs)
    {
        this.blogs = blogs;
    }
}
