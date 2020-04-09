package com.ozge.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozge.entity.Department;



public class HibernateDepartment {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Department.class) //hibernatein hangi tablolarla hangi classla çalışacağını söylüyor.
				.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		
		Department dept=new Department("ozge", 100, 1700);
		session.beginTransaction(); //bir grup iş geliyor
		session.save(dept); // gelen jobs i save et 
		session.getTransaction().commit();//commitle
		session.close();
		
		

	}

}
