package com.springboot.hospital.model;

/**
 * @author MacMuffin
 *
 */
public class Response {

	private int status;
	private String description;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
