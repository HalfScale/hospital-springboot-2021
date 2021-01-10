package com.springboot.hospital.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="test_user")
public class TestUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(mappedBy="testUser", cascade=CascadeType.ALL)
	private TestUserDetail testUserDetail;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TestUserDetail getTestUserDetail() {
		return testUserDetail;
	}

	public void setTestUserDetail(TestUserDetail testUserDetail) {
		this.testUserDetail = testUserDetail;
	}

	@Override
	public String toString() {
		return "TestUser [id=" + id + ", testUserDetail=" + testUserDetail + ", email=" + email + ", password="
				+ password + "]";
	}
	
}
