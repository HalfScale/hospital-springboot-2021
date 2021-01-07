package com.springboot.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospital.model.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

}
