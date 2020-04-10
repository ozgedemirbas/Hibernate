package com.ozge.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozge.entity.Ogretmen;
import com.ozge.entity.OgretmenDetay;

public class HibernateOneToOne {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class) // hibernatein hangi tablolarla hangi classla çalışacağını söylüyor.
				.addAnnotatedClass(OgretmenDetay.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		
		OgretmenDetay ogrDty = session.get(OgretmenDetay.class, 6);
		Ogretmen ogr=session.get(Ogretmen.class, 10);
		
		session.delete(ogr);

		session.getTransaction().commit();
		session.close();
		
		//System.out.println(ogrDty);

		//System.out.println(ogrDty.getOgretmen());

	}

}
