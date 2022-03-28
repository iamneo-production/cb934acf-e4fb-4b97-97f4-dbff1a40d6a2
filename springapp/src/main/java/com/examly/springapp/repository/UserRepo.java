package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    public User getUserByEmail(String email);

    public User findByEmailAndPassword(String email, String password);
}
