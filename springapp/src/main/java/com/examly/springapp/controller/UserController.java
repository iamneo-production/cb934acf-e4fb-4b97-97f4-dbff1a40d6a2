package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.entity.User;
import com.examly.springapp.service.UserService;
import com.examly.springapp.exception.CustomException;
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

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	private User user;
    private String errormsg="No Users Found !!";

	@PostMapping("/addProfile")
	public ResponseEntity<User> addUser(@RequestBody User data) throws CustomException
	{
		user=userService.addUser(data);
		if(user==null){
			throw new CustomException("Couldn't add user details !!");
		}
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/getProfile")
	public ResponseEntity<List<User>> getUsers() throws CustomException
	{
		List<User> users=userService.getUsers();
		
		if(users==null)
		{
			throw new CustomException(errormsg);
		}
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/getProfile/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId)throws CustomException {
		user=userService.getUser(Integer.parseInt(userId));
		if(user==null)
			{
                throw new CustomException(errormsg);
			}
		  
			return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PutMapping("/editProfile/{userId}")
	public  ResponseEntity<User> editUser(@PathVariable String userId,@RequestBody User data)throws CustomException {
		
			user=userService.editUser(Integer.parseInt(userId),data);
			
			if(user==null)
			{
                throw new CustomException(errormsg);
			}
			return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProfile/{userId}")
	public ResponseEntity<Integer> deleteUser(@PathVariable String userId) throws CustomException{
		user=userService.deleteUser(Integer.parseInt(userId));
		if(user==null)
			{
                throw new CustomException(errormsg);
			}
			return new ResponseEntity<>(Integer.parseInt(userId),HttpStatus.OK);
	}
}
