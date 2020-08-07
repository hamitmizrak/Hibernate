package com.java.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable {
	//product ile musicMarket arasında ilişki =product(N) - musicMarket(1)
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private String productPrice;
	
	@ManyToOne  //Product=N karşı taraf=1
	@JoinColumn(name = "musicMarketId") //Foreign Key yani yabancı anahtar= Çoklu yapının içeriğinde oluyor.
	private MusicMarket musicMarket; //Karşı taraf=1
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long productId, String productName, String productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MusicMarket getMusicMarket() {
		return musicMarket;
	}

	public void setMusicMarket(MusicMarket musicMarket) {
		this.musicMarket = musicMarket;
	}
	
	
	
}
