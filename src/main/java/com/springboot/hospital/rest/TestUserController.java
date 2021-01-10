package com.springboot.hospital.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospital.model.Response;
import com.springboot.hospital.model.TestUser;
import com.springboot.hospital.model.TestUserDetail;
import com.springboot.hospital.service.TestUserService;

@RestController
public class TestUserController {
	
	@Autowired
	private TestUserService testUserService;

	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
//	@PostMapping("/processRegistration")
	public Response postUser(@RequestBody TestUser testUser) {
		logger.info(testUser.toString());
		TestUserDetail testUserDetail = testUser.getTestUserDetail();
		testUserDetail.setTestUser(testUser);
		testUserService.save(testUser);
		return new Response();
	}
}
