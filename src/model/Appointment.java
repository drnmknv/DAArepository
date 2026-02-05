package model;

import java.time.LocalDate;

public class Appointment {

    private int id;
    private int patientId;
    private int doctorId;
    private LocalDate date;
    private String status;

    public Appointment(int id, int patientId, int doctorId, LocalDate date, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = status;
    }

    public Appointment(int patientId, int doctorId, LocalDate date, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = status;
    }

    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public LocalDate getDate() { return date; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return id + " | patient " + patientId +
                " | doctor " + doctorId +
                " | " + date +
                " | " + status;
    }
}
