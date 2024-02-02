package com.capgemini.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class OperationClass {
	
	Scanner sc = new Scanner(System.in);
	ConnectionClass connectionObject = new ConnectionClass();
	Connection con = null;
	
	public void insert_record() throws ClassNotFoundException, SQLException {
		
		
		
		System.out.print("Enter Student UID :");
		String studentUID = sc.nextLine();
		System.out.print("Enter Student Name :");
		String studentName = sc.nextLine();
		System.out.print("Enter Student Course :");
		String studentCourse = sc.nextLine();
		System.out.print("Enter Student Batch :");
		int studentBatch = sc.nextInt();
		
		
		if(con == null) {
			con = connectionObject.getConnection();
			
			
			String insertQuery = "INSERT INTO student VALUES(?,?,?,?)";
			
			
			PreparedStatement psmt = con.prepareStatement(insertQuery);
			psmt.setString(1, studentUID);
			psmt.setString(2, studentName);
			psmt.setString(3, studentCourse);
			psmt.setInt(4, studentBatch);
			
			int status = psmt.executeUpdate(); // select - > execute Query, non select -> execute update.
			
			if(status > 0) {
				System.out.println("Record inserted successfully:"+status);
			}
			
			
		}
		
	}

}