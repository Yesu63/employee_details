package com.project;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeManagementSystem {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee_details"; 
		String user = "root";
		String pwd = "yesudas121";
		Connection con = DriverManager.getConnection(url, user, pwd);
		Statement stmt = con.createStatement();
		
		String query = "";
		ResultSet rs;
		PreparedStatement pst;
		
		int emp_id,choice;
		long emp_mobile;
		String emp_name,emp_city;
		double emp_salary;
		
		Scanner in = new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("----------------------------------------EMPLOYEE MANAGEMENT SYSTEM---------------------------------");
			System.out.println("1.INSERT");
			System.out.println("2.UPDATE");
			System.out.println("3.DELETE");
			System.out.println("4.SELECT");
			System.out.println("5.EXIT");
			System.out.println("ENTER YOUR CHOICE : ");
			
			choice = in.nextInt();
			System.out.println();
			switch(choice) {
			case 1:
				
				System.out.println("ENTER EMPLOYEE ID");
				emp_id = in.nextInt();
				System.out.println("ENTER EMPLOYEE NAME");
				emp_name = str.nextLine();
				System.out.println("ENTER EMPLOYEE CITY");
				emp_city = str.nextLine();
				System.out.println("ENTER EMPLOYEE MOBILE NUMBER");
				emp_mobile = in.nextLong();
				System.out.println("ENTER EMPLOYEE SALARY");
				emp_salary = in.nextDouble();
				
				query = "insert into details values (?,?,?,?,?)";
				pst = con.prepareStatement(query);
				
				pst.setInt(1,emp_id);
				pst.setString(2,emp_name);
				pst.setString(3,emp_city);
				pst.setLong(4,emp_mobile);
				pst.setDouble(5,emp_salary);
				pst.executeUpdate();
				System.out.println("DATA INSERT SUCCESS \n");
				break;
			case 2:
				
				System.out.println("ENTER EMPLOYEE ID");
				emp_id = in.nextInt();
				System.out.println("ENTER EMPLOYEE NAME");
				emp_name = str.nextLine();
				System.out.println("ENTER EMPLOYEE CITY");
				emp_city = str.nextLine();
				System.out.println("ENTER EMPLOYEE MOBILE NUMBER");
				emp_mobile = in.nextLong();
				System.out.println("ENTER EMPLOYEE SALARY");
				emp_salary = in.nextDouble();
				
				query = "update details set emp_name=?,emp_city=?,emp_mobile=?,emp_salary=? where emp_id=?";
				pst = con.prepareStatement(query);
				
				
				pst.setString(1,emp_name);
				pst.setString(2,emp_city);
				pst.setLong(3,emp_mobile);
				pst.setDouble(4,emp_salary);
				pst.setInt(5,emp_id);
				pst.executeUpdate();
				System.out.println("DATA UPDATE SUCCESS \n");
				break;
			case 3:
				
				System.out.println("ENTER EMPLOYEE ID");
				emp_id = in.nextInt();
				query = "delete from details where emp_id=?";
				pst = con.prepareStatement(query);
				pst.setInt(1,emp_id);
				pst.executeUpdate();
				System.out.println("DATA DELETE SUCCESS \n");
				break;
			case 4:
				
				query = "select * from details";
				rs = stmt.executeQuery(query);
				System.out.println("id emp_name  emp_city  emp_mobile  emp_salary");
				while(rs.next()) {
					emp_id = rs.getInt("emp_id");
					emp_name = rs.getString("emp_name");
					emp_city = rs.getString("emp_city");
					emp_mobile= rs.getLong("emp_mobile");
					emp_salary = rs.getDouble("emp_salary");
					
					System.out.print(emp_id + " ");
					System.out.print(" "+ emp_name + " ");
					System.out.print(" "+ emp_city + " ");
					System.out.print(" "+ emp_mobile + " ");
					System.out.println(" "+ emp_salary);
				}
				System.out.println();
				break;
			case 5:
				
				System.out.println("THANK YOU");
				System.exit(0);
				break;
			default:
				System.out.println("INVALID SELECTION");
				System.out.println();
			}
			
			//System.out.println("----------------------------------------------");

		}
	}

}
