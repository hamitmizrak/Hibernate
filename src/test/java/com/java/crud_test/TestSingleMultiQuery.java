package com.java.crud_test;

import java.util.ArrayList;
import java.util.List;

import com.java.dao.RegisterHibernateAll;
import com.java.dto.Register;

public class TestSingleMultiQuery {
public static void main(String[] args) {

	/*
	Register register=new Register();
	register=RegisterHibernateAll.getRegisterQuerySingleHibernate(register,2);
	if(register!=null) {
		System.out.println(register.getRegisterId()+" "
				+register.getUserName());
	}else {
		System.out.println("Hiç Bir kayıt bulunamadı.");
	}
*/
	
	
	
	List<Register> register=new ArrayList<Register>();
	register=RegisterHibernateAll.getRegisterQueryListHibernate(register,2L);
	for(Register registerAll: register) {
		System.out.println(registerAll.getRegisterId()+" "
				+registerAll.getUserName());
	}
	
}
}
