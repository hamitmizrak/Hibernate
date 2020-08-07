package com.java.dto;

public class Register {

	private long registerId;
	private String userName;
	private String password;
	
	public Register() {
	}

	public Register(long registerId, String userName, String password) {
		this.registerId = registerId;
		this.userName = userName;
		this.password = password;
	}

	public long getRegisterId() {
		return registerId;
	}

	public void setRegisterId(long registerId) {
		this.registerId = registerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Register [registerId=" + registerId + ", userName=" + userName + ", password=" + password + "]";
	}


	
	
}
