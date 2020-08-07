package com.java.crud_test;

import com.java.dao.RegisterHibernateAll;
import com.java.dto.Register;

public class TestUpdateHibernate {

	public static void main(String[] args) {
		Register register=new Register();
		register=RegisterHibernateAll.getRegisterFindHibernate(register,3);
		register.setUserName("update ad");
		RegisterHibernateAll.getRegisterUpdateHibernate(register);
	}
}
