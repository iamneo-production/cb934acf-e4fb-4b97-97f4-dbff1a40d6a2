package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;
import com.examly.springapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
