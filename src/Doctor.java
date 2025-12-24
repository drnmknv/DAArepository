// Name: Daryn
// Course: Object Oriented Programming
// Project: Hospital Management System
public class Doctor {
    private int id;
    private String name;
    private String specialty;
    private int yearsExperience;
    private boolean onDuty;

    public Doctor() {
        this.id = 0;
        this.name = "Unknown";
        this.specialty = "General";
        this.yearsExperience = 0;
        this.onDuty = true;
    }

    public Doctor(int id, String name, String specialty, int yearsExperience, boolean onDuty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.yearsExperience = yearsExperience;
        this.onDuty = onDuty;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public String getSpecialty() { return this.specialty; }
    public int getYearsExperience() { return this.yearsExperience; }
    public boolean isOnDuty() { return this.onDuty; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public void setYearsExperience(int yearsExperience) {
        if (yearsExperience >= 0) {
            this.yearsExperience = yearsExperience;
        }
    }

    public void setOnDuty(boolean onDuty) { this.onDuty = onDuty; }

    public boolean isSeniorDoctor() {
        return this.yearsExperience >= 10;
    }

    public void addYear() {
        this.yearsExperience++;
    }

    @Override
    public String toString() {
        return "Doctor{id=" + this.id +
                ", name='" + this.name + '\'' +
                ", specialty='" + this.specialty + '\'' +
                ", yearsExperience=" + this.yearsExperience +
                ", onDuty=" + this.onDuty +
                '}';
    }
}
