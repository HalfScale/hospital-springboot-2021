package com.springboot.hospital.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospital.model.Response;

@RestController
public class UserRestController {
	
	@PostMapping("/registration")
	public Response registerUser() {
		return new Response();
	}
}
