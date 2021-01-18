package com.springboot.hospital.service;

import com.springboot.hospital.entity.User;


public interface UserService {

	void save(User user);
	String generateToken();
	User registerNewUserAccount (User user);
	
}
