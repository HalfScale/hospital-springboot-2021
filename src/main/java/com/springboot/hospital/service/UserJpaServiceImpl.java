package com.springboot.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.hospital.dao.UserJpaDAO;
import com.springboot.hospital.model.User;

@Service
public class UserJpaServiceImpl implements UserJpaService {
	
	private UserJpaDAO userJpaDAO;
	
	@Autowired
	public UserJpaServiceImpl (UserJpaDAO userJpaDAO) {
		this.userJpaDAO = userJpaDAO;
	}

	@Override
	public List<User> findAll() {
		return userJpaDAO.findAll();
	}

	@Override
	public User findById(int id) {
		return userJpaDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(User user) {
		userJpaDAO.save(user);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		userJpaDAO.deleteById(theId);
	}

}
