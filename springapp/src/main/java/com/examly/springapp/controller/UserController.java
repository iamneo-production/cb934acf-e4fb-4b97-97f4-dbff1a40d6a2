package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.entity.User;
import com.examly.springapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/addProfile")
	public ResponseEntity<String> addUser(@RequestBody User data)
	{
		try {
			userService.addUser(data);
			return new ResponseEntity<>("User Profile Created",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user/getProfile")
	public ResponseEntity<List<User>> getUsers()
	{
		try {
			return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/user/getProfile/{userId}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable String userId) {
		try {
			return new ResponseEntity<>(userService.getUser(Integer.parseInt(userId)),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/user/editProfile/{userId}")
	public  ResponseEntity<String> editUser(@PathVariable String userId,@RequestBody User data) {
		try {
			userService.editUser(Integer.parseInt(userId),data);
			return new ResponseEntity<>("Updated Profile",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/user/deleteProfile/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		try {
			userService.deleteUser(Integer.parseInt(userId));
			return new ResponseEntity<>("Deleted Profile",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
