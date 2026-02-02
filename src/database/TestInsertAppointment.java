import database.AppointmentDAO;
import model.Appointment;

public class TestInsertAppointment {
    public static void main(String[] args) {
        Appointment a = new Appointment(
                1,        // id (у тебя валидатор требует > 0)
                101,      // patientId
                201,      // doctorId
                "2026-02-03 10:30", // date (String в модели)
                false,    // done
                "Scheduled"
        );

        AppointmentDAO dao = new AppointmentDAO();
        dao.insertAppointment(a);
    }
}
