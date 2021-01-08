package com.springboot.hospital.dao;

import java.util.List;

import com.springboot.hospital.model.User;

public interface UserJpaDAO {
	
	List<User> findAll();
	User findById(int id);
	void save(User user);
	void deleteById(int theId);
}
