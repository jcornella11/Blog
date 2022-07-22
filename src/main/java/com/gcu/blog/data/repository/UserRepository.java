package com.gcu.blog.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.blog.data.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    // Method for finding a user by their username
    UserEntity findByUserName(String userName);
}