package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.service.UserService;
import com.examly.springapp.entity.User;

@RestController
@RequestMapping("/user")
public class SignupController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User registerUser(@RequestBody User user) throws NullPointerException {
        String email = user.getEmail();
        if (email != null && !"".equals(email)) {
            User us = this.userService.getUserByEmailId(email);
            if (us != null) {
                throw new NullPointerException("User with " + email + " already exist.");
            }
        }
        User u = null;
        u = this.userService.saveUser(user);
        return u;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) throws NullPointerException {
        String email = user.getEmail();
        String password = user.getPassword();
        User ob = null;
        if ((email != null && !"".equals(email)) && (password != null && !"".equals(password))) {
            ob = this.userService.getUserByEmailIdAndPassword(email, password);
        }
        if (ob == null) {
            throw new NullPointerException("Bad Credentials");
        }
        return ob;
    }
}
