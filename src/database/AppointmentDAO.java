package database;
import database.DatabaseConnection;
import model.Appointment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


// sql     //arraylsit           //arraylist
// PS     // sql                //sql
// set      //PS                //PS
// return   //RS                 //SET
//catch    //while and list add    //RS , WHILE , LIST.ADD

public class AppointmentDAO {

    public boolean insert(Appointment a) {
        String sql = "INSERT INTO appointments(date, status, description) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(a.getDate()));
            ps.setString(2, a.getStatus());
            ps.setString(3, a.getDescription());
            return ps.executeUpdate() > 0;
        }
        catch (SQLException e) {
            return false;
        }
    }

    public boolean updateStatus(int id, String status) {
        String sql = "UPDATE appointments SET status=? WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM appointments WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Appointment> getAll() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments ORDER BY date";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Appointment(
                        rs.getInt("id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("status"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException ignored) {}
        return list;
    }

    public List<Appointment> searchByStatus(String keyword) {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE status ILIKE ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Appointment(
                        rs.getInt("id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("status"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException ignored) {}
        return list;
    }

    public Appointment getById(int id) {
        String sql = "SELECT * FROM appointments WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next()
                        ? new Appointment(
                        rs.getInt("id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("status"),
                        rs.getString("description")
                )
                        : null;
            }

        } catch (SQLException e) {
            return null;
        }
    }

    public List<Appointment> searchByDateRange(LocalDate from, LocalDate to) {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE date BETWEEN ? AND ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(from));
            ps.setDate(2, Date.valueOf(to));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Appointment(
                        rs.getInt("id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("status"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException ignored) {}
        return list;
    }
}