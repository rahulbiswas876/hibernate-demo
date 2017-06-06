package com.rahul.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session =sessionFactory.getCurrentSession();
		
		try{
			//begin transaction
			session.beginTransaction();
			
			//perform query : list all students 
			List<Student> students = session.createQuery("from Student").list();
			System.out.println("list all students");
			displayStudents(students);
			
			//perform query: list all students whose last_name is 'Pandey'
			students = session.createQuery("from Student s where s.lastName='Pandey'").list();
			System.out.println("\n\ndisplay students with last name 'Pandey'");
			displayStudents(students);
			
			//perform query: list all students whose email ends with @gmail.com
			students = session.createQuery("from Student s where s.email LIKE '%876@gmail.com'").list();
			System.out.println("\n\nlist all students whose email ends with @gmail.com");
			displayStudents(students);
			
			//commit transaction
			session.getTransaction().commit();
		}finally{
			session.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student temp: students) {
			System.out.println(temp);
		}
	}

}
