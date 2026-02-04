package database;

import database.AppointmentDAO;
import model.Appointment;

public class TestInsertAppointment {
    public static void main(String[] args) {
        AppointmentDAO dao = new AppointmentDAO();

        dao.insert(new Appointment(1, 101, 201, "2026-02-02 10:30", false, "Scheduled"));

        dao.selectAll();

        boolean updated = dao.update(new Appointment(1, 101, 201, "2026-02-03 11:00", true, "Done"));
        System.out.println("Updated: " + updated);

        dao.searchByStatus("du");

        dao.searchByDateBetween("2026-02-01", "2026-02-05");

        dao.searchByMinDate("2026-02-03");

        boolean deleted = dao.deleteById(1);
        System.out.println("Deleted: " + deleted);

        dao.selectAll();
    }
}
