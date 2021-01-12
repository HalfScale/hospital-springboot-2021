package com.springboot.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospital.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	// no need to write any code
}
