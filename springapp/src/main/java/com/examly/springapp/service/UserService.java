package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.entity.User;



public interface UserService {
    public User addUser(User data);
    public User getUser(int userId);
    public List<User> getUsers();
    public User editUser(int userId, User data);
    public User deleteUser(int userId);
}
