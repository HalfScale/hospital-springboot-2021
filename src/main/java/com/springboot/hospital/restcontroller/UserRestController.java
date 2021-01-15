package com.springboot.hospital.restcontroller;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospital.entity.Response;
import com.springboot.hospital.entity.User;
import com.springboot.hospital.entity.UserDetail;
import com.springboot.hospital.service.UserService;
import com.springboot.hospital.util.Utils;
import com.springboot.hospital.validator.MySequence;

@RestController
public class UserRestController {
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/processRegistration")
	public Response registerUser(@Validated(MySequence.class) @RequestBody User user, BindingResult result) throws MethodArgumentNotValidException{
		logger.info("Process registration: {}", user.toString());
		
		if (result.hasErrors()) {
			throw new MethodArgumentNotValidException(null, result);
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserDetail userDetail = user.getUserDetail();
		userDetail.setUser(user);
		
		
		logger.info("Before saving: {}", user.toString());
		userService.save(user);
		
		return Utils.<User>generateResponse(0, "Registration successful!", user);
	}
}
