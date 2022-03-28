package com.examly.springapp.service;
import com.examly.springapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.entity.User;

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
    
}
