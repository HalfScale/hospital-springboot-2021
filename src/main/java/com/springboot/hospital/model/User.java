package com.springboot.hospital.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_type")
	private int userType;
	
	@Column(name="registration_token")
	private String registrationToken;
	
	@Column(name="datetime_password_reset")
	private LocalDateTime datetimePasswordReset;
	
	@Column(name="reset_pass_token")
	private String resetPassToken;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="created")
	private LocalDateTime created;
	
	@Column(name="modified")
	private LocalDateTime modified;
	
	@Column(name="deleted")
	private boolean deleted;
	
	@Column(name="deleted_date")
	private LocalDateTime deletedDate;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private UserDetail userDetail;
	
	public User() {
	
	}
	
	public User(int userType, String registrationToken, LocalDateTime datetimePasswordReset, String resetPassToken,
			String email, String password, boolean isConfirmed, boolean enabled, LocalDateTime created,
			LocalDateTime modified, boolean deleted, LocalDateTime deletedDate) {
		this.userType = userType;
		this.registrationToken = registrationToken;
		this.datetimePasswordReset = datetimePasswordReset;
		this.resetPassToken = resetPassToken;
		this.email = email;
		this.password = password;
		this.isConfirmed = isConfirmed;
		this.enabled = enabled;
		this.created = created;
		this.modified = modified;
		this.deleted = deleted;
		this.deletedDate = deletedDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDatetimePasswordReset() {
		return datetimePasswordReset;
	}

	public void setDatetimePasswordReset(LocalDateTime datetimePasswordReset) {
		this.datetimePasswordReset = datetimePasswordReset;
	}

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
		return datetimePasswordReset;
	}

	public void setDateTimePasswordReset(LocalDateTime dateTimePasswordReset) {
		this.datetimePasswordReset = dateTimePasswordReset;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", userType=" + userType + ", registrationToken=" + registrationToken
				+ ", datetimePasswordReset=" + datetimePasswordReset + ", resetPassToken=" + resetPassToken + ", email="
				+ email + ", password=" + password + ", isConfirmed=" + isConfirmed + ", enabled=" + enabled
				+ ", created=" + created + ", modified=" + modified + ", deleted=" + deleted + ", deletedDate="
				+ deletedDate + "]";
	}
	
}
