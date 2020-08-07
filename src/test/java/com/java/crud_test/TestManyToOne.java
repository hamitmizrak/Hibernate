package com.java.crud_test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.java.context.HibernatePersistenceUnitKey;
import com.java.dto.MusicMarket;
import com.java.dto.Product;

public class TestManyToOne {
	public static void main(String[] args) {
		
		//musicmarket(1)
		MusicMarket musicMarket=new MusicMarket();
		musicMarket.setMusicmarketName("MAlatya");
		musicMarket.setProductList(new ArrayList<Product>());
		
		//Product(N)
		Product product=new Product();
		product.setProductName("YEni");
		product.setMusicMarket(musicMarket);
		musicMarket.getProductList().add(product);
		
		//Product(N)
		Product product2=new Product();
		product2.setProductName("YEni2");
		product2.setMusicMarket(musicMarket);
		musicMarket.getProductList().add(product2);
		
		
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(HibernatePersistenceUnitKey.KEY);
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			
			entityManager.getTransaction().begin();
			entityManager.persist(musicMarket); //Tek olanın içeirğinde çok bileşen var
			entityManager.getTransaction().commit();
			
			entityManager.close();
			System.out.println("Ekleme Başarıyla gerçekleşti.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
