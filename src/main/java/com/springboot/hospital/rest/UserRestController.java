package com.springboot.hospital.rest;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.springboot.hospital.validator.MySequence;

@RestController
public class UserRestController {
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	private UserService userService;
	
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	@PostMapping("/processRegistration")
	public Response registerUser(@Validated(MySequence.class) @RequestBody User user, BindingResult result) throws MethodArgumentNotValidException{
		logger.info("Process registration: {}", user.toString());
		
		if (result.hasErrors()) {
			throw new MethodArgumentNotValidException(null, result);
		}
		
		UserDetail userDetail = user.getUserDetail();
		userDetail.setUser(user);
//		userService.save(user);
		
		Map data = new HashMap();
		data.put("user", user);
		return new Response(0, "Registration successful!", data);
	}
}
