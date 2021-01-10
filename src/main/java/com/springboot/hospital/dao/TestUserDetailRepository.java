package com.springboot.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospital.model.TestUserDetail;

public interface TestUserDetailRepository extends JpaRepository<TestUserDetail, Integer>{
	
}
