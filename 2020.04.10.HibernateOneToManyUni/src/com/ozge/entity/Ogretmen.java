package com.ozge.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity //kayıtlı sorgu denebilir.  
@Table(name="OGRETMEN")
public class Ogretmen {
	
	
	@Id //bu nesnenin unic anahtar olduğunu belşrtmem gerekiyor ıdenfier hatasında burası sorunlu oluyor belirtmem lazım
	@Column(name="id")
	@SequenceGenerator(name="ogretmen_seq", sequenceName ="SEQ_OGRETMEN", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ogretmen_seq")
	
	
	/*
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	private Integer id;
	
	@OneToOne(cascade=CascadeType.ALL) //bir ilişkinin getirdiğinin gereğini yapmak
	@JoinColumn(name="ogretmendetay")
	private OgretmenDetay ogretmenDetay;
	
	@Column(name="first_name")
	private String firstName; 
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	@OneToMany(mappedBy = "ogretmen", cascade=CascadeType.ALL) //Kurs sınıfındaki öğretmen alanı bu ilişkiyi yönetiyor. Kurstaki öğretmen nasıl map edildiyse bu kolon ona bakar :) 
	// Cascade ile ilişkinin silindiği durumları kontrol edip ona göre işlem yapcak.
	private List<Kurs> kurslar;  //dersleri ekleyip çıkarcak bir method yazmalıyız.
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OgretmenDetay getOgretmenDetay() {
		return ogretmenDetay;
	}

	public void setOgretmenDetay(OgretmenDetay ogretmenDetay) {
		this.ogretmenDetay = ogretmenDetay;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ogretmen(OgretmenDetay ogretmenDetay, String firstName, String lastName, String email) {
		super();
		this.ogretmenDetay = ogretmenDetay;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Ogretmen() {
	
	}

	public List<Kurs> getKurslar() {
		return kurslar;
	}


	public void setKurslar(List<Kurs> kurslar) {
		this.kurslar = kurslar;
	}

	public void addKurs(Kurs kurs) {
		
		if (kurslar==null) {
			kurslar=new ArrayList<Kurs>();
		}
		kurslar.add(kurs);
		kurs.setOgretmen(this);
		
	}
	
	
	
	
	
	
	
	

}
