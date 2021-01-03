package com.springboot.hospital.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospital.dao.UserDAO;
import com.springboot.hospital.model.Response;
import com.springboot.hospital.model.User;

@RestController
public class UserRestController {
	
	private UserDAO userDAO;
	
	@Autowired
	public UserRestController(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userDAO.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable int id) {
		return userDAO.findById(id);
	}
	
	@PostMapping("/registration")
	public Response registerUser() {
		return new Response();
	}
	
	
}
