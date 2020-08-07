package com.java.test;

import com.java.dao.RegisterHibernateAll;
import com.java.dto.Register;

public class TestInsertHibernate {

	public static void main(String[] args) {
		Register register=new Register();
		register.setUserName("Hamit Mızrak");
		register.setPassword("123456");
		
		RegisterHibernateAll.getRegisterInsertHibernate(register);
	}
}
