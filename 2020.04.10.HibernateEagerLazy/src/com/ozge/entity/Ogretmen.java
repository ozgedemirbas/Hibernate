package com.ozge.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity  
@Table(name="OGRETMEN")
public class Ogretmen {
	
	
	@Id 
	@Column(name="id")
	@SequenceGenerator(name="ogretmen_seq", sequenceName ="SEQ_OGRETMEN", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ogretmen_seq")
	private Integer id;
	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="ogretmen", cascade = CascadeType.ALL)
	private List<Kurs> kurslar;  
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ogretmendetay")
	private OgretmenDetay ogretmenDetay;
	
	@Column(name="first_name")
	private String firstName; 
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;


	
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
