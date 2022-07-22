package com.gcu.blog.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.blog.data.entity.BlogEntity;
import com.gcu.blog.data.repository.BlogRepository;

@Service
public class BlogDataService implements DataAccessInterface<BlogEntity>{

    @Autowired
    private BlogRepository blogRepository;

    public BlogDataService(BlogRepository blogRepository)
    {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogEntity> findAll()
    {
        List<BlogEntity> blogs = new ArrayList<BlogEntity>();

        try {
            Iterable<BlogEntity> blogIterable = blogRepository.findAll();

            blogIterable.forEach(blogs::add);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return blogs;
    }

    @Override
    public BlogEntity findById(int id)
    {
        Optional<BlogEntity> blog = blogRepository.findById((long) id);

        return blog.get();
    }

    @Override
    public boolean create(BlogEntity blog)
    {
        try {
            blogRepository.save(blog);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(BlogEntity blog)
    {
        try
        {
            blogRepository.save(blog);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(BlogEntity blog)
    {
        try
        {
            blogRepository.delete(blog);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
