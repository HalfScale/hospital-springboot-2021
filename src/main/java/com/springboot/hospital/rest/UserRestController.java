package com.springboot.hospital.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospital.model.User;
import com.springboot.hospital.service.UserService;

@RestController
public class UserRestController {
	
	private UserService userService;
	
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable int id) {
		
		User user = userService.findById(id);
		
		if (user == null) {
			throw new RuntimeException("Employee id: " + id + " not found!");
		}
		
		return userService.findById(id);
	}
	
	@PostMapping("/users")
	public User registerUser(@RequestBody User user) {
		
		// just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		user.setId(0);
		userService.save(user);
		return user;
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		userService.save(user);
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		User user = userService.findById(id);
		
		if (user == null) {
			throw new RuntimeException("User id: " + id + " is not existing");
		}
		
		userService.deleteById(id);
		return "Deleted user id: " + id;
	}
	
	
}
