package com.examly.springapp.service;



import java.util.List;


import com.examly.springapp.entity.User;
import com.examly.springapp.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserRepo userDao;
	private User user;

	public User addUser(User data) {
		
		return userDao.save(data);
	}

	public User getUser(int userId) {
		return userDao.findById(userId).orElse(null);
	}

	public List<User> getUsers() {
		return userDao.findAll();
	}

	public User editUser(int userId, User data) {
		user=getUser(userId);
		if(user!=null)
		{
			data.setUserId(userId);
			userDao.save(data);	
			return data;
		}
		else
		{
			return null;
		}
	}

	public User deleteUser(int userId) {
		user=getUser(userId);
		if(user!=null)
		{
		  userDao.delete(user);
		}	
	    return user;	
		
	}

}
