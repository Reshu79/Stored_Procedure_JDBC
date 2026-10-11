
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    static String url ="jdbc:mysql://localhost:3306/student_records";
    static String user ="root";
    static String password ="root";

    public static Connection dbconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
                DriverManager.getConnection(url, user, password);

            System.out.println("Database connected successfully!");
            return conn;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(dbconnection());
    }
}
