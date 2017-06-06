package com.rahul.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {

		String jdbcUrl ="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try{
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successfull");
			
		}catch(Exception exc) { 
			exc.printStackTrace();
		}
	}

} 
