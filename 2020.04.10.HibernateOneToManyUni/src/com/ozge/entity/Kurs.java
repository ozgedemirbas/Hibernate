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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity  
@Table(name="KURS")
public class Kurs {
	
	@Id 
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

	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL) //bir kursun n tane konusu olabilir
	@JoinColumn(name="kurs_id") //konular listesi aslında konu tablosunda bulduğumuz tüm konular. Kursun konularının hepsi için
	private List<Konu> konular;
	
	public List<Konu> getKonular() {
		return konular;
	}


	public void setKonular(List<Konu> konular) {
		this.konular = konular;
	}


	public void addKonu(Konu konu) {
		if(konular == null)
		{
			konular= new ArrayList<Konu>();
		}
		konular.add(konu);
	}
	
	
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


	@Override
	public String toString() {
		return "Kurs [id=" + id + ", kursadi=" + kursadi + ", saat=" + saat + ", ogretmen=" + ogretmen + ", konular="
				+ konular + "]";
	}
	
	
	

}
