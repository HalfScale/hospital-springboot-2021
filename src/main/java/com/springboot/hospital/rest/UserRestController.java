package com.springboot.hospital.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospital.model.Response;
import com.springboot.hospital.model.UserDetail;
import com.springboot.hospital.service.UserService;

@RestController
public class UserRestController {
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	private UserService userService;
	
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	@PostMapping("/processRegistration")
	public Response registerUser(@RequestBody UserDetail user) {
		logger.info(user.toString());
		return new Response();
	}
}
