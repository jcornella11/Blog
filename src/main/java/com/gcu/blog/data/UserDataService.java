package com.gcu.blog.data;

import java.util.List;

import com.gcu.blog.BlogApplication;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.blog.data.entity.UserEntity;
import com.gcu.blog.data.repository.UserRepository;

@Service
public class UserDataService implements DataAccessInterface<UserEntity> {

    private final static Logger logger = Logger.getLogger(BlogApplication.class);

    @Autowired
    private UserRepository userRepository;

    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean create(UserEntity newUser) {

        try {
            //Save new UserEntity to database
            userRepository.save(newUser);
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }

        logger.info("Inside the Create Method of the UserDataService");
        return true;
    }

    @Override
    public List<UserEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserEntity findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(UserEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(UserEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    public UserEntity findByUserName(String username) {
        // Attempt to find user by username
        logger.info("Inside the find by UserName Method of the UserDataService");
        return userRepository.findByUserName(username);
    }
}
