package com.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.java.dto.Register;

public class RegisterHibernateAll {
/*
 Paketler= javax.persistence üzerinden alıyoruz.
 
 Create-Delete-Update için mutlaka Transaction yapmak gerekiyor. ancak select için transcation yapmıyoruz.
 Insert keyword= Persist()
 Delete keyword= remove()
 Update keyword=
 
 select keyword=
 
 */

	private static EntityManagerFactory entityManagerFactory=null;
	private static EntityManager entityManager=null;

	
	
	//EntityManager Config
	private static EntityManager getEntityManagerConfig(EntityManager entityManager) {
		entityManagerFactory=Persistence.createEntityManagerFactory("MyPersistenceUnit");
		entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	//Insert Matodu =transcation olacak
	public static  void  getRegisterInsertHibernate(Register  register) {
		try {
			entityManager= getEntityManagerConfig(entityManager);
			entityManager.getTransaction().begin(); 
			entityManager.persist(register);
			entityManager.getTransaction().commit();//transaction kapat
			entityManager.close();
			System.out.println("Ekleme başarıyla eklendi:"+register.getRegisterId());
		}catch(Exception e){
			System.err.println("Hibernate Nesne Ekleme Sırasında Hata oluştu:"+e);
			e.printStackTrace();
		}
	}
	
	
	//Delete metodu
		public static  void  getRegisterDeleteHibernate(Register  register, long ID) {
			try {
			entityManager= getEntityManagerConfig(entityManager);
			entityManager.getTransaction().begin(); 
			register=entityManager.getReference(Register.class, ID); //bulma işleminin bir başka türü find işlemine göre göre daha hızlı
			entityManager.remove(register);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("Nesne Silindi:"+register.getRegisterId());
			}catch(Exception e){
				System.err.println("Hibernate Nesne Silme Sırasında Hata oluştu:"+e);
				e.printStackTrace();
			}
		}
	
}
