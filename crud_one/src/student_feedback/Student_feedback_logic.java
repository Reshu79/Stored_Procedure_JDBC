package student_feedback;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class Student_feedback_logic {//itha main la poi call pannano
	static String student="create table student("
                          +"id int primary key auto_increment,"
			              +"sname varchar(20),"
                          +"dates date,"
			              +"reg_no bigint"
                          +");";
	Scanner o=new Scanner(System.in);
	public static void Create() {
		Connection conn=DBconnection.dbconnection();
		try {
		Statement st=conn.createStatement();
		st.executeUpdate(student);
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String insert="insert into student(sname,dates,reg_no)value(?,?,?);";
	public  void inserts() {
		System.out.println("Enter ur name:");
		String student_name=o.nextLine();
		System.out.println("enter ur date");
		String dates=o.nextLine();
		System.out.println("enter ur reg_no");
		Long reg_no=o.nextLong();
		o.nextLine();
		try {
			Connection conn=DBconnection.dbconnection();
			PreparedStatement ps=conn.prepareStatement(insert);
			ps.setString(1,student_name);
			ps.setString(2, dates);
			ps.setLong(3, reg_no);
			int row=ps.executeUpdate();
			if(row==1) {
				System.out.println(row+"data stored successfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	static String print="select*from student;";
	public static void print() {
		try {
		Connection conn=DBconnection.dbconnection();
		Statement stat=conn.createStatement();
		ResultSet rs=stat.executeQuery(print);
		while(rs.next()) {
			System.out.println(rs.getInt("id")+"||"+rs.getString("sname")+"||"+rs.getString("dates")+"||"+rs.getString("reg_no"));
		}
		
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
	public void update() {
		Connection conn=DBconnection.dbconnection();
		String update="update student set sname=?,dates=?,reg_no=? where id=?;";
		System.out.println("Enter ur id");
		int id=o.nextInt();
		o.nextLine();
		System.out.println("Enter ur sname");
		String sname=o.nextLine();
		System.out.println("Enter ur dates");
		String dates=o.nextLine();
		System.out.println("Enter ur reg_no");
		long reg_no=o.nextLong();//bigint in sql so long in java
		try {
		PreparedStatement pse=conn.prepareStatement(update);
		pse.setString(1,sname);
		pse.setString(2, dates);
		pse.setLong(3, reg_no);
		pse.setInt(4,id);
		int row=pse.executeUpdate();
		if(row==1) {
			System.out.println("id:"+id+","+"sname:"+sname+","+"dates:"+dates+","+"reg_no:"+reg_no);
		}
		else {
			System.out.println("please enter crt id to update");
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
                           
    public void delete() {
    	     Connection conn=DBconnection.dbconnection();
    	     String delete="delete from student where id=?;";
    	     System.out.println("Enter the id to delete");
    	     int id=o.nextInt();
    	     try {
    	     PreparedStatement ps=conn.prepareStatement(delete);
    	     ps.setInt(1, id);
    	     int row=ps.executeUpdate();
    	     if(row==1) {
    	    	 System.out.println("data was deleted suceesfully");
    	     }
    	     else {
    	    	 System.out.println("wrong id which is not present in database");
    	     }
    	     }catch(SQLException e) {
    	    	 System.out.println(e.getMessage());
    	     }
    }
    public void method() {
    	String query="select * from student;";
    	Connection conn=DBconnection.dbconnection();
    	try {
			Statement ps=conn.createStatement();//either S+33tatement or PreparedStatement
			ResultSet rs=ps.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getDate(3));//it will return the first column athula tha count aaki values irukko
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
    	
    }
}
