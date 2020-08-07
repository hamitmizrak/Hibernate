package com.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.java.context.HibernatePersistenceUnitKey;

public class RegisterHibernateAll {
/*
 Paketler= javax.persistence üzerinden alıyoruz.
 
 Create-Delete-Update için mutlaka Transaction yapmak gerekiyor. ancak select için transcation yapmıyoruz.
 Create keyword=
 Delete keyword=
 Update keyword=
 
 select keyword=
 
 */

	private static EntityManagerFactory entityManagerFactory=null;
	private static EntityManager entityManager=null;
	private static HibernatePersistenceUnitKey hibernatePersistenceUnitKey;
	
	
	//EntityManager Config
	private static EntityManager getEntityManagerConfig(EntityManager entityManager) {
		entityManagerFactory=Persistence.createEntityManagerFactory(hibernatePersistenceUnitKey.KEY);
		entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
}
