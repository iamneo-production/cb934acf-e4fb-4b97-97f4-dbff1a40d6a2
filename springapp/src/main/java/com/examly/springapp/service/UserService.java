package com.examly.springapp.service;
import com.examly.springapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.entity.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user) {
        return this.userRepo.save(user);
    }

    public User getUserByEmailId(String email) {
        return this.userRepo.getUserByEmail(email);
    }

    public User getUserByEmailIdAndPassword(String email, String password) {
        return this.userRepo.findByEmailAndPassword(email, password);
    }

    public User getUserById(int id) {
        User u = this.userRepo.findUserById(id);
        return u;
    }

    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    public void updateUser(User user, int id) {
        user.setId(id);
        userRepo.save(user);
    }

    public void deleteUser(int id) {
        this.userRepo.deleteById(id);
    }
    
}
