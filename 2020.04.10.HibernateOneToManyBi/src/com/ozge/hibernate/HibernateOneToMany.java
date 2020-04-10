package com.ozge.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozge.entity.Kurs;
import com.ozge.entity.Ogretmen;
import com.ozge.entity.OgretmenDetay;

public class HibernateOneToMany {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class) 
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(OgretmenDetay.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		/*Ogretmen ogr = new Ogretmen(null, "Ali", "Can", "a@a");
		
		ogr.addKurs(new Kurs("Java", 600, ogr));
		ogr.addKurs(new Kurs("DB", 400, null));
		ogr.addKurs(new Kurs("WEB", 500, null));
		
		*/
		
	
		
		/*List<Kurs> kurslar = session.createQuery("from Kurs where ogretmen=11").getResultList();
		
		for (Kurs dept: kurslar) {
			System.out.println(dept.getKursadi());
		}
		*/
		session.beginTransaction();
		
		Ogretmen ogr = session.get(Ogretmen.class, 11);
		
		Kurs k = ogr.getKurslar().get(0);
		ogr.getKurslar().remove(0);
		
		session.remove(k);
		
		Kurs k2 = ogr.getKurslar().get(0);
		k2.setKursadi("db2");
		session.save(k2);
		session.save(ogr);
		
	
		
		
		session.getTransaction().commit();
		session.close();
		
		//System.out.println(ogrDty);

		//System.out.println(ogrDty.getOgretmen());

	}

}
