package com.gcu.blog.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.gcu.blog.data.entity.BlogEntity;

public class BlogRowMapper implements RowMapper <BlogEntity>{

    @Override
    public BlogEntity mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return new BlogEntity(
                rs.getLong("ID"),
                rs.getString("AUTHOR_NAME"),
                rs.getString("TITLE"),
                rs.getString("INTRODUCTION"),
                rs.getString("BODY"),
                rs.getString("CONCLUSION")
                );
    }
}
