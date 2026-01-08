// Name: Daryn
// Course: Object Oriented Programming
// Project: Hospital Management System

public class Appointment {

    private int id;
    private int patientId;
    private int doctorId;
    private String date;
    private boolean done;
    private String status;

    // ====== DEFAULT CONSTRUCTOR ======
    public Appointment() {
        this.id = 0;
        this.patientId = 0;
        this.doctorId = 0;
        this.date = "TBD";
        this.done = false;
        this.status = "Scheduled";
    }

    // ====== PARAMETERIZED CONSTRUCTOR
    public Appointment(int id, int patientId, int doctorId, String date, boolean done, String status) {
        setId(id);
        setPatientId(patientId);
        setDoctorId(doctorId);
        setDate(date);
        this.done = done;
        setStatus(status);
    }

    // ====== GETTERS ======
    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public boolean isDone() { return done; }
    public String getStatus() { return status; }

    // ====== SETTERS WITH VALIDATION ======
    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            System.out.println("Invalid appointment ID!");
        }
    }

    public void setPatientId(int patientId) {
        if (patientId >= 0) {
            this.patientId = patientId;
        }
    }

    public void setDoctorId(int doctorId) {
        if (doctorId >= 0) {
            this.doctorId = doctorId;
        }
    }

    public void setDate(String date) {
        if (date != null && !date.trim().isEmpty()) {
            this.date = date;
        } else {
            System.out.println("Invalid date!");
        }
    }

    public void setStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status;
        } else {
            System.out.println("Invalid status!");
        }
    }

    // ====== BEHAVIOR METHODS ======
    public boolean reschedule(String newDate) {
        if (done || status.equals("Cancelled")) {
            return false;
        }
        setDate(newDate);
        return true;
    }

    public void markDone() {
        done = true;
        status = "Completed";
    }

    public void cancel() {
        if (!done) {
            status = "Cancelled";
        }
    }

    // ====== OUTPUT ======
    @Override
    public String toString() {
        return "Appointment{id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", date='" + date + '\'' +
                ", done=" + done +
                ", status='" + status + '\'' +
                '}';
    }
}
