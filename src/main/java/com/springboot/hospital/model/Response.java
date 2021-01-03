package com.springboot.hospital.model;

import java.util.Map;

/**
 * @author MacMuffin
 *
 */
public class Response {

	private int status;
	private String description;
	private Map data;
	
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
