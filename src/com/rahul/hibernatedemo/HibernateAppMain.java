package com.rahul.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateAppMain {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session =sessionFactory.getCurrentSession();
		
		try{
			//creating student object to save it
			Student stud = new Student("Rahul","Biswas","rbiswas876@gmail.com");
			
			//begin transaction
			session.beginTransaction();
			
			//save the object
			System.out.println("saving Student to db");
			session.save(stud);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}finally{
			session.close();
		}
	}

}
