package com.ozge.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity //kayıtlı sorgu denebilir.  
@Table(name="OGRETMENDETAY")
public class OgretmenDetay {
	
	
	@Id //bu nesnenin unic anahtar olduğunu belşrtmem gerekiyor ıdenfier hatasında burası sorunlu oluyor belirtmem lazım
	@Column(name="id")
	@SequenceGenerator(name="ogretmen_det_seq", sequenceName ="SEQ_OGRETMENDETAY", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ogretmen_det_seq")
	private Integer id;
	
	
	@OneToMany(mappedBy = "ogretmen", cascade=CascadeType.ALL) //Kurs sınıfındaki öğretmen alanı bu ilişkiyi yönetiyor. Kurstaki öğretmen nasıl map edildiyse bu kolon ona bakar :) 
															// Cascade ile ilişkinin silindiği durumları kontrol edip ona göre işlem yapcak.
	

	@OneToOne (mappedBy="ogretmenDetay") //column olarak tanımlamıyorum ki ilişki var arada onu sağlayıp ikinc bir kanal açtım
	private Ogretmen ogretmen;
	
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


	public Ogretmen getOgretmen() {
		return ogretmen;
	}


	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
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
