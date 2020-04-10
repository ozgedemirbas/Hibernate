package com.ozge.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozge.entity.Ogretmen;
import com.ozge.entity.OgretmenDetay;



public class HibernateDepartment {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class) //hibernatein hangi tablolarla hangi classla çalışacağını söylüyor.
				.addAnnotatedClass(OgretmenDetay.class)
				.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		OgretmenDetay ogrdty=new OgretmenDetay("java1", "1sinema", "nhjdsks", "nsdsdf");
		Ogretmen dept=new Ogretmen(ogrdty, "aa", "bb", "a@an");
		
		
		
		
		session.beginTransaction(); //bir grup iş geliyor
		//session.save(ogrdty);
		session.save(dept); // gelen jobs i save et 
		session.getTransaction().commit();//commitle
		session.close();
		
		

	}

}
