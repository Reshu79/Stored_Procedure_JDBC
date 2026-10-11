package stored_procedure;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Stored_procedure_logic {
	static String store="create procedure stored(in snames varchar(20),in ages int,in departments varchar(20)) "
	        +"begin "
	        +"insert into details(sname,age,department) values (snames,ages,departments);"
	        +"end ";
	public static void create() {
		Connection conn=DBconnection.dbconnection();
		try {
			Statement st=conn.createStatement();
			st.executeUpdate(store);
			System.out.println("stored procedure created sucessfully");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	        

}
