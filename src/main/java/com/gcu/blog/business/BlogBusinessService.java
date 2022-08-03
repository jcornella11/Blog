package com.gcu.blog.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.blog.BlogApplication;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.blog.data.BlogDataService;
import com.gcu.blog.data.entity.BlogEntity;
import com.gcu.blog.models.BlogModel;


public class BlogBusinessService implements BlogBusinessInterface{

    private final static Logger logger = Logger.getLogger(BlogApplication.class);

    @Autowired
    private BlogDataService service;

    public List<BlogModel> getBlog()
    {
        //Retrieve List of Blog Entitys from Database
        List<BlogEntity> blogEntity = service.findAll();

        //Empty List of Blog Models to Hold Results
        List<BlogModel> blogDomain = new ArrayList<BlogModel>();

        for(BlogEntity entity: blogEntity)
        {
            blogDomain.add(new BlogModel(entity.getId(),
                    entity.getAuthorName(),
                    entity.getTitle(),
                    entity.getIntroduction(),
                    entity.getBody(),
                    entity.getConclusion()));
        }

        logger.info("Inside the Get Blog Method of the Blog Business Service");

        return blogDomain;
    }

    public boolean addBlog(BlogModel blogModel)
    {
        BlogEntity entity = new BlogEntity(null,
                blogModel.getAuthorName(),
                blogModel.getTitle(),
                blogModel.getIntroduction(),
                blogModel.getBody(),
                blogModel.getConclusion());

        logger.info("Inside the Add Blog Method of the Blog Business Service");

        return service.create(entity);
    }

    @Override
    public BlogModel getBlogById(int id)
    {
        BlogEntity entity = service.findById(id);

        logger.info("Inside the getBlogById Method of the Blog Business Service");

        return new BlogModel(entity.getId(),
                entity.getAuthorName(),
                entity.getTitle(),
                entity.getIntroduction(),
                entity.getBody(),
                entity.getConclusion()
                );
    }

    @Override
    public boolean deleteBlog(BlogModel blogModel)
    {
        BlogEntity entity = new BlogEntity(blogModel.getId(),
                blogModel.getAuthorName(),
                blogModel.getTitle(),
                blogModel.getIntroduction(),
                blogModel.getBody(),
                blogModel.getConclusion());

        logger.info("Inside the deleteBlogById Method of the Blog Business Service");
        return service.delete(entity);
    }

    @Override
    public boolean updateBlog(BlogModel blogModel)
    {
        BlogEntity entity = new BlogEntity(
                blogModel.getId(),
                blogModel.getAuthorName(),
                blogModel.getTitle(),
                blogModel.getIntroduction(),
                blogModel.getBody(),
                blogModel.getConclusion());

        logger.info("Inside the updateBlog Method of the Blog Business Service");

        return service.update(entity);
    }


}
