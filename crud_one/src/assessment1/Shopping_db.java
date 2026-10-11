package assessment1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Shopping_db {
	static String create="create table shopping("
            +"prod_id int,"
            +"prod_name varchar(20),"
            +"price int,"
            +"quantity varchar(20)"
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
	static String inserts="insert into shopping(prod_id,prod_name,price,quantity) values(?,?,?,?);";
	public static void insertion() {
		Connection conn=DBconnection.dbconnection();
		System.out.println("Enter the prod_id:");
		int prod_id=o.nextInt();
		o.nextLine();
		System.out.println("Enter the prod_name:");
		String prod_name=o.nextLine();
		System.out.println("Enter the price:");
		int price=o.nextInt();
		o.nextLine();
		System.out.println("Enter the quantity:");
		String quantity=o.nextLine();
		
		try {
			PreparedStatement ps=conn.prepareStatement(inserts);
			ps.setInt(1,prod_id);
			ps.setString(2,prod_name);
			ps.setInt(3,price);
			ps.setString(4, quantity);
			int row=ps.executeUpdate();
			if(row==1) {
				System.out.println("the data was inserted");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	static String displays="select* from shopping;";
	public static void display() {
		Connection conn=DBconnection.dbconnection();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(displays);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3)+","
			+rs.getString(4));
			}
			
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}


}

	


