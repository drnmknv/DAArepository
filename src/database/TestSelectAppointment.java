import database.AppointmentDAO;

public class TestSelectAppointment {
    public static void main(String[] args) {
        AppointmentDAO dao = new AppointmentDAO();
        dao.getAllAppointments();
    }
}
