package stored_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Stored_procedure_logic_4 {
	static String call= "{call getEmployeeSalary(?)}";
	public static  void callable() {
		Connection conn=DBconnection.dbconnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int id=sc.nextInt();
		try {
			CallableStatement cs=conn.prepareCall(call);
			cs.setInt(1,id);
			boolean state=cs.execute();
			if(state) {
				ResultSet rs=cs.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getInt("sal"));
				}
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
