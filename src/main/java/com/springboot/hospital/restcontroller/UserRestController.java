package com.springboot.hospital.restcontroller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@Autowired
	private JavaMailSender javaMailSender;
	
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
	
	@GetMapping("/sendMail")
	public Response sendMail() {
		
		String targetEmail = "halfscale3@gmail.com";
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(targetEmail);
		msg.setSubject("Testing from Spring Boot");
		msg.setText("\"This should be a generated token!\"");
		
		javaMailSender.send(msg);
		
		return Utils.generateResponse(0, "Message Sent to email " + targetEmail, "Message sent.");
	}
}
