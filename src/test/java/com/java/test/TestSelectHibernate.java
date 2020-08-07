package com.java.test;

import com.java.dao.RegisterHibernateAll;
import com.java.dto.Register;

public class TestSelectHibernate {
public static void main(String[] args) {
	Register r3=new Register();
	r3=RegisterHibernateAll.getRegisterSelectHibernate(r3,2);
	System.out.println(r3.getRegisterId()+" "
			 +r3.getUserName());
			
}
}