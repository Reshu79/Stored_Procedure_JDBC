package stored_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Stored_procedure_logic_2 {
	static String creates="create table student("+
                   "id int primary key auto_increment,"+
			       "name varchar(20),"+
                   "age int,"+
			       "dept varchar(20)"+
                   ");";
	static Scanner sc=new Scanner(System.in);
	public static void creation() {
		Connection conn=DBconnection.dbconnection();
		try {
			Statement st=conn.createStatement();
			st.executeUpdate(creates);
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	static private String inserts="insert into student (name,age,dept)values(?,?,?)";
	public static void insertion() {
		System.out.println("enter ur name:");
		String name=sc.nextLine();
		System.out.println("enter ur age:");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("enter ur dept");
		String dept=sc.nextLine();
		Connection conn=DBconnection.dbconnection();
		try {
			PreparedStatement ps=conn.prepareStatement(inserts);
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setString(3, dept);
			int row=ps.executeUpdate();
			if(row==1) {
				System.out.println("row inserted successfully");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	static String stored_procedure="create procedure sp(in names varchar(20),in ages int,in depts varchar(20)) "
			+"begin "
			+"insert into student(name,age,dept)values(names,ages,depts); "
			+"end ";
	public static void storing() {
		Connection conn=DBconnection.dbconnection();
        try {
        	Statement st=conn.createStatement();
        st.executeUpdate(stored_procedure);
        	
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
	}
	static String call= "{call sp(?,?,?)}";
	public static void calling() {
		System.out.println("enter ur name:");
		String name=sc.nextLine();
		System.out.println("enter ur age:");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("enter ur dept:");
		String dept=sc.nextLine();
		Connection conn=DBconnection.dbconnection();
		try {
			CallableStatement ps=conn.prepareCall(call);
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setString(3,dept);
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
                   

}
