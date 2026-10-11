package assessment1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Company_db {
	static String create="create table employee("
            +"emp_id int primary key,"
            +"emp_name varchar(20),"
            +"salary bigint,"
            +"department varchar(20)"
            +");";
	static Scanner o=new Scanner(System.in);
	public static void creation() {
		Connection conn=DBconnection.dbconnection();
		try {
			Statement st=conn.createStatement();
			st.executeUpdate(create);
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	static String inserts="insert into employee(emp_id,emp_name,salary,department) values(?,?,?,?);";
	public static void insertion() {
		Connection conn=DBconnection.dbconnection();
		System.out.println("Enter the emp_id:");
		int emp_id=o.nextInt();
		o.nextLine();
		System.out.println("Enter the emp_name:");
		String emp_name=o.nextLine();
		System.out.println("Enter the salary:");
		double salary=o.nextDouble();
		o.nextLine();
		System.out.println("Enter the department:");
		String department=o.nextLine();
		
		try {
			PreparedStatement ps=conn.prepareStatement(inserts);
			ps.setInt(1,emp_id);
			ps.setString(2,emp_name);
			ps.setDouble(3,salary);
			ps.setString(4,department);
			int row=ps.executeUpdate();
			if(row==1) {
				System.out.println("the data was inserted");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	static String displays="select *from employee;";
	public static void display() {
		Connection conn=DBconnection.dbconnection();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(displays);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getDouble(3)+","+rs.getString(4));
			}
			
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
