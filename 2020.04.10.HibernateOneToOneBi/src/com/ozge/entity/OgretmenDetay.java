package com.ozge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity //kayıtlı sorgu denebilir.  
@Table(name="OGRETMENDETAY")
public class OgretmenDetay {
	
	
	@Id //bu nesnenin unic anahtar olduğunu belşrtmem gerekiyor ıdenfier hatasında burası sorunlu oluyor belirtmem lazım
	@Column(name="id")
	@SequenceGenerator(name="ogretmen_det_seq", sequenceName ="SEQ_OGRETMENDETAY", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ogretmen_det_seq")
	
	
	/*
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	private Integer id;
	
	@Column(name="expertise")
	private String expersite; 
	
	@Column(name="hobby")
	private String hobby;
	
	@Column(name="website")
	private String website;


	@Column(name="fbpage")
	private String fbpage;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getExpersite() {
		return expersite;
	}


	public void setExpersite(String expersite) {
		this.expersite = expersite;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getFbpage() {
		return fbpage;
	}


	public void setFbpage(String fbpage) {
		this.fbpage = fbpage;
	}


	public OgretmenDetay(String expersite, String hobby, String website, String fbpage) {
		super();
		this.expersite = expersite;
		this.hobby = hobby;
		this.website = website;
		this.fbpage = fbpage;
	}


	public OgretmenDetay() {
	
	}


	
	
	
	
	
	
	
	

}
