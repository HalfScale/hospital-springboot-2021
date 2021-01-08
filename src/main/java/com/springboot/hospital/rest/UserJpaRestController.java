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
import com.springboot.hospital.service.UserJpaService;

@RestController
public class UserJpaRestController {

	private UserJpaService userJpaService;

	@Autowired
	public UserJpaRestController(UserJpaService userJpaService) {
		this.userJpaService = userJpaService;
	}
	
	@GetMapping("/jpa/users")
	public List<User> findAll() {
		return userJpaService.findAll();
	}
	
	@GetMapping("/jpa/user/{id}")
	public User findById(@PathVariable int id) {
		System.out.println("/jpa/user/{id} = " + id);
		return userJpaService.findById(id);
	}
	
	@PostMapping("/jpa/users")
	public User registerUser(@RequestBody User user) {
		user.setId(0);
		userJpaService.save(user);
		return user;
	}
	
	@PutMapping("/jpa/users")
	public User updateUser(@RequestBody User user) {
		userJpaService.save(user);
		return user;
	}
	
	@DeleteMapping("/jpa/user/{id}")
	public String deleteUser(@PathVariable int id) {
		User user = userJpaService.findById(id);
		
		if (user == null) {
			throw new RuntimeException("User id: " + id + " is not existing");
		}
		
		userJpaService.deleteById(id);
		
		return "Deleted user id: " + id;
	}
}
