package com.java.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MusicMarket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long musicMarketId;
	
	private String musicmarketName;
	private String musicmarketAddress;
	
	//constructıra olmaycak sadece GETTER SETTER
	@OneToMany(mappedBy="musicMarket" ,cascade = CascadeType.ALL) //cascade = CascadeType.ALL= anlamı Bu classta olan biten diğer classta aynı şekilde olması demektir.  //mappedBy="Product içeriğindeki yazdım"
	private List<Product> productList;
	
	public MusicMarket() {
		// TODO Auto-generated constructor stub
	}
	
	public MusicMarket(long musicMarketId, String musicmarketName, String musicmarketAddress) {
		this.musicMarketId = musicMarketId;
		this.musicmarketName = musicmarketName;
		this.musicmarketAddress = musicmarketAddress;
	}

	public long getMusicMarketId() {
		return musicMarketId;
	}
	public void setMusicMarketId(long musicMarketId) {
		this.musicMarketId = musicMarketId;
	}
	public String getMusicmarketName() {
		return musicmarketName;
	}
	public void setMusicmarketName(String musicmarketName) {
		this.musicmarketName = musicmarketName;
	}
	public String getMusicmarketAddress() {
		return musicmarketAddress;
	}
	public void setMusicmarketAddress(String musicmarketAddress) {
		this.musicmarketAddress = musicmarketAddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//product Setter Getter
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
}
