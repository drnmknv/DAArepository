package model;

import exception.ValidationException;

public class Appointment implements Schedulable {

    private int id;
    private int patientId;
    private int doctorId;
    private String date;
    private boolean done;
    private String status;

    public Appointment() {
        this.id = 1;
        this.patientId = 1;
        this.doctorId = 1;
        this.date = "TBD";
        this.done = false;
        this.status = "Scheduled";
    }

    public Appointment(int id, int patientId, int doctorId, String date, boolean done, String status) {
        setId(id);
        setPatientId(patientId);
        setDoctorId(doctorId);
        setDate(date);
        setStatus(status);
        this.done = done;
    }

    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public boolean isDone() { return done; }
    public String getStatus() { return status; }

    public void setId(int id) {
        if (id <= 0) throw new ValidationException("Appointment ID must be positive.");
        this.id = id;
    }

    public void setPatientId(int patientId) {
        if (patientId <= 0) throw new ValidationException("Patient ID must be positive.");
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        if (doctorId <= 0) throw new ValidationException("Doctor ID must be positive.");
        this.doctorId = doctorId;
    }

    public void setDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            throw new ValidationException("Date cannot be empty.");
        }
        this.date = date.trim();
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new ValidationException("Status cannot be empty.");
        }
        this.status = status.trim();
    }

    @Override
    public boolean reschedule(String newDate) {
        if (done || "Cancelled".equalsIgnoreCase(status)) return false;
        setDate(newDate);
        return true;
    }

    public void markDone() {
        done = true;
        status = "Completed";
    }

    public void cancel() {
        if (!done) status = "Cancelled";
    }

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
