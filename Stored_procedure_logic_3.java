package stored_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Stored_procedure_logic_3 {
	static String create="create procedure transfer_Amount(in sender_no int,in receiver_no int,in amount int) "
			+"begin "
			+"update account set balance=balance-amount where account_no=sender_no; "
			+"update account set balance=balance+amount where account_no=receiver_no; "
			+"end ";
	
			public static void Amount() {
		     Connection conn=DBconnection.dbconnection();
		     try {
		    	 Statement st=conn.createStatement();
		    	 st.executeUpdate(create);
		     }catch(SQLException e) {
		    	 System.out.println(e.getMessage());
		     }
	}
		static String call="{call transfer_Amount(?,?,?)}";
		public static void calling() {
			Connection conn=DBconnection.dbconnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter ur sender_no");
			int sender_no=sc.nextInt();
			System.out.println("enter ur receiver_no");
			int receiver_no=sc.nextInt();
			System.out.println("enter ur amount");
			int amount=sc.nextInt();
			
			try {
				CallableStatement cs=conn.prepareCall(call);
				cs.setInt(1,sender_no);
				cs.setInt(2, receiver_no);
				cs.setInt(3, amount);
				cs.execute();
				
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}

}
