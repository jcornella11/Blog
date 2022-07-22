package com.gcu.blog.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.gcu.blog.data.entity.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new UserEntity(rs.getInt("ID"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getString("EMAIL"),
                rs.getString("PHONE_NUMBER"),
                rs.getString("USER_NAME"),
                rs.getString("PASSWORD"));
    }
}
