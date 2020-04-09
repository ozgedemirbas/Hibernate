package com.ozge.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozge.entity.Department;

public class HibernateUpdate {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Department.class) // hibernatein hangi tablolarla hangi classla çalışacağını
														// söylüyor.
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		Department dept = session.get(Department.class, 20);

		dept.setDeptname("Marketing");

		session.getTransaction().commit();
		

		/*session.beginTransaction();

		session.createQuery("update Department set deptname='PAZARLAMA' where dept_id=20")
		.executeUpdate();

		session.getTransaction().commit();
*/
	}

}
