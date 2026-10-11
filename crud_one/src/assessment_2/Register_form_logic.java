package assessment_2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;

import student_feedback.DBconnection;

public class Register_form_logic {
	static Scanner o=new Scanner(System.in);
    static public String insert="insert into student(sname,age,department)value(?,?,?);";
	public  static void inserts() {
		System.out.println("Enter ur name:");
		String sname=o.nextLine();
		System.out.println("enter ur age");
		int age=o.nextInt();
		o.nextLine();
		System.out.println("enter ur department");
		String department=o.nextLine();
		
		try {
			Connection conn=DBconnection.dbconnection();
			PreparedStatement ps=conn.prepareStatement(insert);
			ps.setString(1,sname);
			ps.setInt(2,age);
			ps.setString(3,department);
			int row=ps.executeUpdate();
			if(row>0) {
				System.out.println("data stored successfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
//	static String create_store="create procedure store(in names varchar(20),in ages int,in departments varchar(20);"
//			                   +"begin "
//	                           +"insert into student(sname,age,department)values(names,ages,departments);"
//	                           +"end";
//	                           
//	public static void create_procedure() {
//		Connection conn=DBconnection.dbconnection();
//		try {
//			Statement st=conn.createStatement();
//			st.executeUpdate(create_store);
//		}catch(SQLException e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
//	String call= {"call store(Ureshma,20,cse);"};
//	public static void callable() {
//		CallableStatement=conn.prepareStatement();
//		
//	}

}
