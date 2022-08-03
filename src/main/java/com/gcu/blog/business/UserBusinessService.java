package com.gcu.blog.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.blog.BlogApplication;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gcu.blog.data.UserDataService;
import com.gcu.blog.data.entity.UserEntity;
import com.gcu.blog.models.UserModel;
import com.gcu.blog.data.UserDataService;

@Component
public class UserBusinessService implements UserDetailsService {

    private final static Logger logger = Logger.getLogger(BlogApplication.class);

    @Autowired
    UserDataService service;

    public boolean addUser(UserModel newUser) {

        // Create UserEntity from UserModel
        UserEntity entity = new UserEntity(newUser.getId(),
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getPhoneNumber(),
                newUser.getEmail(),
                newUser.getUserName(),
                newUser.getPassword());

        // Attempt insertion of UserEntity into database with UserDataService
        // Return boolean indicating success or failure

        logger.info("Inside the addUser Method of the User Data Service");
        return service.create(entity);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Call service and return user by username
        UserEntity user = service.findByUserName(username);

        logger.info("Inside the loadUserByUSername Method of the User Data Service");

        // If user found add authorities of "USER"
        if(user != null)
        {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUserName(), user.getPassword(), authorities);
        }
        else
        {
            throw new UsernameNotFoundException("Username not found");
        }
    }


}
