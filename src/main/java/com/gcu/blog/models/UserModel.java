package com.gcu.blog.models;

import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


public class UserModel {

    @Id
    private int id;

    @Size(min = 1, max = 10, message = "name must be between 1 and 10 characters")
    private String firstName;

    @Size(min = 1, max = 10, message = "name must be between 1 and 10 characters")
    private String lastName;

    @Email(message = "Valid email is required")
    private String email;

    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}$", message = "Valid phone number is required")
    private String phoneNumber;

    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String userName;

    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    public UserModel() {
    }

    public UserModel(int id, String firstName, String lastName, String email, String phoneNumber, String userName,
                     String password) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
