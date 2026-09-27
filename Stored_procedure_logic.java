package stored_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Stored_procedure_logic {
	 String store="create procedure prod( "
                    +"in snames varchar(20), "
	                +"in ages int, "
	                +"in departments varchar(20)) "
	                +"begin "
	                +"insert into details(sname,age,department) "
	                +"values(snames,ages,departments); "
	                +"select * from details ;"
	                +"end" ;
	public  void create() {
		Connection conn=DBconnection.dbconnection();
		try {
			Statement st=conn.createStatement();
			st.executeUpdate(store);
			System.out.println("stored procedure created sucessfully");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	String reteive="{call prod(?,?,?)}";
	public void callable() {
		Connection conn=DBconnection.dbconnection();
		Scanner o=new Scanner(System.in);
		System.out.println("enter the sname:");
		String sname=o.nextLine();
		System.out.println("enter the age:");
		int age=o.nextInt();
		o.nextLine();
		System.out.println("enter the department:");
		String department=o.nextLine();
		
		try {
			CallableStatement cs=conn.prepareCall(reteive);
			cs.setString(1,sname);
			cs.setInt(2,age);
			cs.setString(3, department);
			boolean res=cs.execute();//its return type is boolean
			System.out.println(res);
			if(res) {
				ResultSet rs=cs.getResultSet();
				while(rs.next()) {
				System.out.println(rs.getString("sname")+"||"+rs.getInt("age")+"||"+rs.getString("department"));
				}
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	        

}
