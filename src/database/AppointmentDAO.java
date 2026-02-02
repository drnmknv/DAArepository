package database;

import model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentDAO {

    public void insertAppointment(Appointment a) {
        String sql = "INSERT INTO appointment (id, patient_id, doctor_id, date, done, status) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setInt(2, a.getPatientId());
            ps.setInt(3, a.getDoctorId());
            ps.setString(4, a.getDate());
            ps.setBoolean(5, a.isDone());
            ps.setString(6, a.getStatus());

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Appointment inserted successfully!");

            ps.close();
        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }

    public void getAllAppointments() {
        String sql = "SELECT * FROM appointment";
        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- ALL APPOINTMENTS ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                int patientId = rs.getInt("patient_id");
                int doctorId = rs.getInt("doctor_id");
                String date = rs.getString("date");
                boolean done = rs.getBoolean("done");
                String status = rs.getString("status");

                System.out.println("ID: " + id +
                        " | patientId=" + patientId +
                        " | doctorId=" + doctorId +
                        " | date=" + date +
                        " | done=" + done +
                        " | status=" + status);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
}