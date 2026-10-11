package student_feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	//jdbc->java database connector;
	private static String url="jdbc:mysql://localhost:3306/studentfeedback";
	private static String user="root";
	private static String password="root";
	
	public static Connection dbconnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,user,password);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	

}
