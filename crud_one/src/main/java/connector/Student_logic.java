
package connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Student_model;
import model.DBconnection;

public class Student_logic {

    public String toInsert(Student_model sm) {

        String insertion =
            "INSERT INTO student_info(ec_no, s_name, feedback) VALUES (?, ?, ?)";

        try (Connection conn = DBconnection.dbconnection()) {

            if (conn == null) {
                return "Database connection failed. Check Eclipse Console.";
            }

            try (PreparedStatement ps = conn.prepareStatement(insertion)) {

                ps.setInt(1, sm.getEc_no());
                ps.setString(2, sm.getS_name());
                ps.setString(3, sm.getFeedback());

                int row = ps.executeUpdate();

                if (row > 0) {
                    return "Student record stored successfully!";
                }

                return "Record was not inserted.";

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Insert failed: " + e.getMessage();
        }
    }
}
