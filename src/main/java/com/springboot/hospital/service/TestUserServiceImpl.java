package com.springboot.hospital.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.hospital.dao.TestUserRepository;
import com.springboot.hospital.model.TestUser;
import com.springboot.hospital.rest.UserRestController;

@Service
public class TestUserServiceImpl implements TestUserService {
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private TestUserRepository testUserRepository;

	@Override
	public void save(TestUser testUser) {
		logger.info(testUser.toString());
		testUserRepository.save(testUser);
	}

}
