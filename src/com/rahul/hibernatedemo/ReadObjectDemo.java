package com.rahul.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadObjectDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session =sessionFactory.getCurrentSession();
		
		try{
			//creating student object to save it
			Student stud = new Student("Abhi","Pandey","abhi@gmail.com");
			System.out.println("Before begning transaction student object is:" + stud);
			
			//begin transaction
			session.beginTransaction();
			
			//save the object
			System.out.println("saving Student to db");
			session.save(stud);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			System.out.println(stud +"\n\n\n");
			
			
			//get  session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the saved student based on primay key
			Student newStud = session.get(Student.class,stud.getId());
			
			
			//commit transaction
			session.getTransaction().commit();
			
			//show the retrieved object
			System.out.println("Retrieved student is:" + newStud);
			
			
			
			
			
		}finally{
			session.close();
		}
	}

}
