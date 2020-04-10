package com.ozge.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozge.entity.Kurs;
import com.ozge.entity.Ogretmen;
import com.ozge.entity.OgretmenDetay;

public class HibernateEagerLazy {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class) 
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(OgretmenDetay.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		/*Ogretmen ogr = new Ogretmen(null, "Alicc", "Can", "aa22aaaaaaaa@a");
		
		ogr.setOgretmenDetay(new OgretmenDetay("java1", "kdkd", "jf", "jfkjf"));
		
		ogr.addKurs(new Kurs("Java11", 600, ogr));
		ogr.addKurs(new Kurs("DB11", 400, null));
		ogr.addKurs(new Kurs("WEB11", 500, null));
		
	*/
		session.beginTransaction();

		Ogretmen Alicc =session.get(Ogretmen.class, 13);
		//Alicc.getKurslar().size();
		System.out.println(Alicc);

		System.out.println(Alicc.getKurslar());
		
		
		session.getTransaction().commit();
		session.close();
	

	}

}
