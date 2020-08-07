package com.java.dto;

import java.io.Serializable;
import java.util.List;

public class MusicMarket implements Serializable {

	private static final long serialVersionUID = 1L;
	private long musicMarketId;
	private String musicmarketName;
	private String musicmarketAddress;
	
	//constructıra olmaycak sadece GETTER SETTER
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
