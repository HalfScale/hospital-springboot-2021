package com.springboot.hospital.dao;

import java.util.List;

import com.springboot.hospital.model.User;

public interface UserDAO {
	
	public List<User> findAll();
	public User findById(int id);
	public void save(User user);
	public void deleteById(int theId);
}
