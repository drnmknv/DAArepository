package model;

import java.time.LocalDate;

public class Appointment {

    private int id;
    private LocalDate date;
    private String status;
    private String description;

    public Appointment(int id, LocalDate date, String status, String description) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.description = description;
    }

    public Appointment(LocalDate date, String status, String description) {
        this.date = date;
        this.status = status;
        this.description = description;
    }

    public int getId() { return id; }
    public LocalDate getDate() { return date; }
    public String getStatus() { return status; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return id + " | " + date + " | " + status + " | " + description;
    }
}
