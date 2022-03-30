package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.examly.springapp.service.UserService;
import com.examly.springapp.entity.User;
import com.examly.springapp.exception.CustomException;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<User> getUsers() throws CustomException {
        List<User> ls = this.userService.getAllUser();
        if (ls.size() <= 0) {
            throw new CustomException();
        }
        return ls;
    }

    @GetMapping("/getUser/{userId}")
    public User findUserById(@PathVariable("userId") int id) throws CustomException {
        User user = null;
        user = this.userService.getUserById(id);
        if (user == null) {
            throw new CustomException();
        }
        return user;
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) throws CustomException {
        User u = null;
        try {
            u = this.userService.saveUser(user);
        } catch (Exception e) {
            throw new CustomException();
        }
        return u;
    }

    @PutMapping("/editUser/{userId}")
    public String editUser(@RequestBody User user, @PathVariable("userId") int id) throws CustomException {
        try {
            this.userService.updateUser(user, id);
        } catch (Exception e) {
            throw new CustomException();
        }

        return "Successfully Edited";
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") int id) throws CustomException {
        try {
            this.userService.deleteUser(id);
        } catch (Exception e) {
            throw new CustomException();
        }
        return "Successfully Deleted";
    }
}
