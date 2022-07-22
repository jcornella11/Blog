package com.gcu.blog.business;

import java.util.List;

import com.gcu.blog.data.entity.BlogEntity;
import com.gcu.blog.models.BlogModel;

public interface BlogBusinessInterface {

    public List<BlogModel> getBlog();

    public boolean addBlog(BlogModel blogModel);

    public BlogModel getBlogById(int id);

    public boolean deleteBlog(BlogModel blogModel);

    public boolean updateBlog(BlogModel blogModel);
}
