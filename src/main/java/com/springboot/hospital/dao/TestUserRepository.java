package com.springboot.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospital.model.TestUser;

public interface TestUserRepository extends JpaRepository<TestUser, Integer>{

}
