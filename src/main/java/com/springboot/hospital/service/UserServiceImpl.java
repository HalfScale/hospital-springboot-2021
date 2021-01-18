package com.springboot.hospital.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.hospital.dao.UserRepository;
import com.springboot.hospital.entity.User;
import com.springboot.hospital.entity.UserDetail;
import com.springboot.hospital.restcontroller.UserRestController;

@Service
public class UserServiceImpl implements UserService{
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}
	
	@Override
	public String generateToken() {
		return passwordEncoder.encode(UUID.randomUUID().toString()); 
	}

	@Override
	public User registerNewUserAccount(User user) {
		logger.info("Process registration: {}", user.toString());
		
		String token = generateToken();
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRegistrationToken(token);
		UserDetail userDetail = user.getUserDetail();
		userDetail.setUser(user);
		
		
		logger.info("Before saving: {}", user.toString());
		
		return userRepository.save(user);
	}
	
	private boolean emailExist(String email) {
		return userRepository.findByEmail(email).isPresent();
	}
	
	
}
