package com.ozge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity //kayıtlı sorgu denebilir.  
@Table(name="KURS")
public class Kurs {
	
	
	@Id //bu nesnenin unic anahtar olduğunu belşrtmem gerekiyor ıdenfier hatasında burası sorunlu oluyor belirtmem lazım
	@Column(name="id")
	@SequenceGenerator(name="kurs_seq", sequenceName ="SEQ_KURS", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "kurs_seq")
	private int id;
	
	
	@Column(name="kurs_adi")
	private String kursadi;
	
	@Column(name="saat")
	private Integer saat;
	
	@ManyToOne //bir çok kurs aynı öğretmene gidebilir
	@JoinColumn(name="ogretmen_id")
	private Ogretmen ogretmen;

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKursadi() {
		return kursadi;
	}

	public void setKursadi(String kursadi) {
		this.kursadi = kursadi;
	}

	public Integer getSaat() {
		return saat;
	}

	public void setSaat(Integer saat) {
		this.saat = saat;
	}


	public Kurs(String kursadi, Integer saat, Ogretmen ogretmen) {
		super();
		this.kursadi = kursadi;
		this.saat = saat;
		
		this.ogretmen = ogretmen;
	}

	public Kurs() {
		super();
	}
	
	
	

}
