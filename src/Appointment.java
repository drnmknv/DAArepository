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

    public Appointment() {
        this.id = 0;
        this.patientId = 0;
        this.doctorId = 0;
        this.date = "TBD";
        this.done = false;
        this.status = "Scheduled";
    }

    public Appointment(int id, int patientId, int doctorId, String date, boolean done, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.done = done;
        this.status = status;
    }

    public int getId() { return this.id; }
    public int getPatientId() { return this.patientId; }
    public int getDoctorId() { return this.doctorId; }
    public String getDate() { return this.date; }
    public boolean isDone() { return this.done; }
    public String getStatus() { return this.status; }

    public void setId(int id) { this.id = id; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public void setDate(String date) { this.date = date; }
    public void setDone(boolean done) { this.done = done; }
    public void setStatus(String status) { this.status = status; }

    public boolean reschedule(String newDate) {
        if (this.done || this.status.equals("Cancelled")) {
            return false;
        }
        this.date = newDate;
        return true;
    }

    public void markDone() {
        this.done = true;
        this.status = "Completed";
    }

    public void cancel() {
        if (!this.done) {
            this.status = "Cancelled";
        }
    }

    @Override
    public String toString() {
        return "Appointment{id=" + this.id +
                ", patientId=" + this.patientId +
                ", doctorId=" + this.doctorId +
                ", date='" + this.date + '\'' +
                ", done=" + this.done +
                ", status='" + this.status + '\'' +
                '}';
    }
}
