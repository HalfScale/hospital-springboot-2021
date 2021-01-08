package com.springboot.hospital.rest;


import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospital.model.Response;
import com.springboot.hospital.model.User;
import com.springboot.hospital.service.UserService;

@RestController
public class UserRestController {
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	private UserService userService;
	
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping("/log")
	public Response logTest() {
		logger.error("Testing logger...");
		return new Response(0, "testing logger...", new HashMap());
	}
	
	@PostMapping("/processRegistration")
	public Response registerUser(@RequestBody User user) {
		logger.error("Testing logger...");
		return new Response();
	}
}
