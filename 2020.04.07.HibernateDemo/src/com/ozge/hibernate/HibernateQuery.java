package com.ozge.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozge.entity.Department;


public class HibernateQuery {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Department.class) //hibernatein hangi tablolarla hangi classla çalışacağını söylüyor.
				.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
	
		
		session.beginTransaction();
		
		//HQL:Hibernate Query Language
		List<Department> depts = session.createQuery("from Department where locationid=1700").getResultList();
		
		
		for(Department dept : depts) {
			System.out.println(dept.getDeptname());
		}

		session.getTransaction().commit();
		

	}

}
