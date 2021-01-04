package com.springboot.hospital.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospital.model.Response;
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
	
	@PostMapping("/registration")
	public Response registerUser() {
		return new Response();
	}
	
	
}
