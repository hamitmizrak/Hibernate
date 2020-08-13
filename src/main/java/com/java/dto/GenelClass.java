package com.java.dto;

import java.sql.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="tabloAdim")
@Named("genelClassim")
@ApplicationScoped
public class GenelClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable = true)
	private long GenelClassId;
	
	@Column(name="product_name",length = 100)
	private String productName;

	@Column(name="randevu",length = 10)
	@Temporal(TemporalType.DATE)
	private Date randevu;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Transient //Db yazılmayacak
	private boolean isNull;
	
	@Lob
	private String buyukVeri;
	
	@Transient
	public void Deneme() {
		
	}
	
}
