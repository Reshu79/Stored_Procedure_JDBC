package assessment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	static String url="jdbc:mysql://localhost:3306/shopping_db";
	static String user="root";
	static String password="root";
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
