package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.entity.User;
import com.examly.springapp.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo userDao;
	
	public void addUser(User data) {
		userDao.save(data);
	}

	public Optional<User> getUser(int userId) {
		return userDao.findById(userId);
	}

	public List<User> getUsers() {
		return userDao.findAll();
	}

	public void editUser(int userId, User data) {
		List<User> users=userDao.findAll();
		users.forEach(user->{
			if(user.getUserId()==userId)
			{
				userDao.save(data);	
			}
		});
		
	}

	public void deleteUser(int userId) {
		User data=userDao.findUserByUserId(userId);
		userDao.delete(data);
		
	}

}
