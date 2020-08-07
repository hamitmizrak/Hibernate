package com.java.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //otomatik olarak artırım sağlamak
	private long registerId;
	private String userName;
	private String password;
	
	//parametresiz constructor
	public Register() {
	}

	//parametreli constructor
	public Register(long registerId, String userName, String password) {
		this.registerId = registerId;
		this.userName = userName;
		this.password = password;
	}

	//Getter and Setter
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

	

	
	
}
