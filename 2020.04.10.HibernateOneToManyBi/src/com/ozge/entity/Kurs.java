package com.ozge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int saat;
	
	@Column(name="ogretmen_id")
	private int ogretmenid;

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

	public int getSaat() {
		return saat;
	}

	public void setSaat(int saat) {
		this.saat = saat;
	}

	public int getOgretmenid() {
		return ogretmenid;
	}

	public void setOgretmenid(int ogretmenid) {
		this.ogretmenid = ogretmenid;
	}
	
	
	

}
