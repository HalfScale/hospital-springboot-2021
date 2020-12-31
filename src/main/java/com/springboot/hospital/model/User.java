package com.springboot.hospital.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	private int userType;
	
	private String registrationToken;
	
	private LocalDateTime dateTimePasswordReset;
	
	private String resetPassToken;
	
	private String email;
	
	private String password;
	
	private boolean isConfirmed;
	
	private boolean enabled;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	private boolean deleted;
	
	private LocalDateTime deletedDate;

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getRegistrationToken() {
		return registrationToken;
	}

	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}

	public LocalDateTime getDateTimePasswordReset() {
		return dateTimePasswordReset;
	}

	public void setDateTimePasswordReset(LocalDateTime dateTimePasswordReset) {
		this.dateTimePasswordReset = dateTimePasswordReset;
	}

	public String getResetPassToken() {
		return resetPassToken;
	}

	public void setResetPassToken(String resetPassToken) {
		this.resetPassToken = resetPassToken;
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

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public LocalDateTime getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(LocalDateTime deletedDate) {
		this.deletedDate = deletedDate;
	}
	
	
}
