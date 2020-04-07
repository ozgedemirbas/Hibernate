package com.ozge.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozge.entity.Departments;
import com.ozge.entity.Jobs;

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Jobs.class) //hibernatein hangi tablolarla hangi classla çalışacağını söylüyor.
				.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		
		Jobs jobs=new Jobs("TEST", "Test Mühendisi", 3000, 5000);
		session.beginTransaction(); //bir grup iş geliyor
		session.save(jobs); // gelen jobs i save et 
		session.getTransaction().commit();//commitle
		session.close();
		
		

	}

}
