package database;

import model.Appointment;

import java.sql.*;

public class AppointmentDAO {

    public void insert(Appointment a) {
        String sql = "INSERT INTO appointment (id, patient_id, doctor_id, date, done, status) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, a.getId());
            ps.setInt(2, a.getPatientId());
            ps.setInt(3, a.getDoctorId());
            ps.setString(4, a.getDate());
            ps.setBoolean(5, a.isDone());
            ps.setString(6, a.getStatus());

            ps.executeUpdate();
            System.out.println("Inserted!");
        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        }
    }

    public void selectAll() {
        String sql = "SELECT * FROM appointment ORDER BY id";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- APPOINTMENTS ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getInt("patient_id") + " | " +
                                rs.getInt("doctor_id") + " | " +
                                rs.getString("date") + " | " +
                                rs.getBoolean("done") + " | " +
                                rs.getString("status")
                );
            }
        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        }
    }

    public boolean update(Appointment a) {
        String sql = "UPDATE appointment SET patient_id=?, doctor_id=?, date=?, done=?, status=? WHERE id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setString(3, a.getDate());
            ps.setBoolean(4, a.isDone());
            ps.setString(5, a.getStatus());
            ps.setInt(6, a.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update failed!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM appointment WHERE id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
            return false;
        }
    }

    public void searchByStatus(String keyword) {
        String sql = "SELECT * FROM appointment WHERE status ILIKE ? ORDER BY id";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%"); // wildcard
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("\n--- SEARCH status contains: " + keyword + " ---");
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +
                                    rs.getString("date") + " | " +
                                    rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();
        }
    }

    public void searchByDateBetween(String from, String to) {
        String sql = "SELECT * FROM appointment WHERE date BETWEEN ? AND ? ORDER BY date";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, from);
            ps.setString(2, to);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("\n--- SEARCH date BETWEEN " + from + " AND " + to + " ---");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " | " + rs.getString("date") + " | " + rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Range search failed!");
            e.printStackTrace();
        }
    }

    public void searchByMinDate(String minDate) {
        String sql = "SELECT * FROM appointment WHERE date >= ? ORDER BY date";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, minDate);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("\n--- SEARCH date >= " + minDate + " ---");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " | " + rs.getString("date") + " | " + rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Min search failed!");
            e.printStackTrace();
        }
    }
}
