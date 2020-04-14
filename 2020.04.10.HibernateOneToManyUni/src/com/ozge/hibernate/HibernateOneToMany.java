package com.ozge.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozge.entity.Konu;
import com.ozge.entity.Kurs;
import com.ozge.entity.Ogretmen;
import com.ozge.entity.OgretmenDetay;

public class HibernateOneToMany {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class) 
				.addAnnotatedClass(Ogretmen.class) 
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Konu.class)
				.addAnnotatedClass(OgretmenDetay.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		Ogretmen ogr = session.get(Ogretmen.class, 13);
		
		Kurs kurs = new Kurs("java301",001,ogr);
		
		kurs.addKonu(new Konu("OOP301", "Inheritance, Polimorfhizim"));
		kurs.addKonu(new Konu("OOP401", "InheritanceEE, PolimorfhizimMM"));
		
	
		session.save(kurs);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Kurs : "+kurs);
		System.out.println("");
		System.out.println(kurs.getKonular());
		

	}

}
