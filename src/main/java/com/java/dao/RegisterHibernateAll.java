package com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java.dto.Register;

public class RegisterHibernateAll {
/*
 Paketler= javax.persistence üzerinden alıyoruz.
 
 Create-Delete-Update için mutlaka Transaction yapmak gerekiyor. ancak select için transcation yapmıyoruz.
 Insert keyword= Persist()
 Delete keyword= remove()
 Update keyword= find() merge()
 
 select keyword= find()
 single query= query.getSingleResult();
 multi  query=
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
		
		
		//update metodu
		public static  Register  getRegisterFindHibernate(Register  register , long ID) {

			try {
				entityManager= getEntityManagerConfig(entityManager);
				entityManager.getTransaction().begin(); 
				register=entityManager.find(Register.class, ID);
				}catch(Exception e){
					System.err.println("Hibernate Nesne Güncelleme Sırasında Hata oluştu:"+e);
					e.printStackTrace();
				}
			return register;
		}
		//update metodu
		public static  void  getRegisterUpdateHibernate(Register  register) {

			try {
				entityManager.merge(register);// güncellemede persist  yerine merge kullanıyoruz.
				entityManager.getTransaction().commit();
				entityManager.close();
				System.out.println("Register Güncellendi:"+register.getRegisterId());
				}catch(Exception e){
					System.err.println("Hibernate Nesne Güncelleme Sırasında Hata oluştu:"+e);
					e.printStackTrace();
				}
		}
		
		
		//select metodu
		public static  Register  getRegisterSelectHibernate(Register  register,long ID) {
			try {
				entityManager= getEntityManagerConfig(entityManager);
				register=entityManager.find(Register.class, ID);  //Register.class bunun adı class literal
				entityManager.close();
				System.out.println("Nesne Seçildi.:"+register.getRegisterId());
			
				}catch(Exception e){
					System.err.println("Hibernate Nesne Listeleme Sırasında Hata oluştu:"+e);
					e.printStackTrace();
				}
			return register;
		}
		
		
		//QuerySingle metodu
		public static  Register  getRegisterQuerySingleHibernate(Register  register,long ID) {
			try {
				entityManager= getEntityManagerConfig(entityManager);
				String jpql="select register44 from Register as register44 where register44.registerId=:registerId2olan";
				TypedQuery<Register> query=entityManager.createQuery(jpql,Register.class); 
				query.setParameter(	"registerId2olan", ID);
				register=query.getSingleResult();
				entityManager.close();
			}catch (NoResultException noResult) {
				register=null;
			}
			catch (NonUniqueResultException nonResult) {
				register=null;
			}
			return register;
		}

		//QueryList metodu
		public static  List<Register>   getRegisterQueryListHibernate(List<Register> registerList,long ID) {
			try {
				entityManager= getEntityManagerConfig(entityManager);
				//jpa query java ile sql birleşimi
				//String jpql="select register44 from Register as register44"; // select register44 from Register register44  VEYA   from Register
				//String jpql="select register44 from Register as register44 where register44.registerId=2";//VEYA Alttakini yap daha düzgün
				String jpql="select register44 from Register as register44 where register44.registerId>:registerId2olan";
				//String jpql="select register44 from Register as register44" + "where register44.registerId=:registerId2olan"; //böylede gösterilebilinir.
				
				TypedQuery<Register> query=entityManager.createQuery(jpql,Register.class);  // Bunun hemen altakinden farkı tür güvenliğini sağlıyor javax.persistence.Query
				//Query query=entityManager.createQuery(jpql=java persistence query language); 
				
				query.setParameter(	"registerId2olan", ID);
				registerList=query.getResultList();
				entityManager.close();
				}catch(Exception e){
					System.err.println("Hibernate Nesne Listeleme Sırasında Hata oluştu:"+e);
					e.printStackTrace();
				}
			return registerList;
		
		}
	
}
