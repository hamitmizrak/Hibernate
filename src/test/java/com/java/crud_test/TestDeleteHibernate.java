package com.java.crud_test;

import com.java.dao.RegisterHibernateAll;
import com.java.dto.Register;

public class TestDeleteHibernate {

	public static void main(String[] args) {
		long ID=1L;
		
		Register register=new Register();
		register.setUserName("Hamit Mızrak");
		register.setPassword("123456");
		
		RegisterHibernateAll.getRegisterDeleteHibernate(register, ID);
	}
}
