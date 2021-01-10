package com.springboot.hospital.rest;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospital.model.Response;
import com.springboot.hospital.model.User;
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
	public Response registerUser(@RequestBody User user) {
		logger.info("Process registration: {}", user.toString());
		
		UserDetail userDetail = user.getUserDetail();
		userDetail.setUser(user);
		userService.save(user);
		
		Map data = new HashMap();
		data.put("user", user);
		return new Response(0, "Registration successful!", data);
	}
}
