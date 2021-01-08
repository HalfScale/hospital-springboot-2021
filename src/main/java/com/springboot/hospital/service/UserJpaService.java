package com.springboot.hospital.service;

import java.util.List;

import com.springboot.hospital.model.User;

public interface UserJpaService {

	List<User> findAll();
	User findById(int id);
	void save(User user);
	void deleteById(int theId);
}
