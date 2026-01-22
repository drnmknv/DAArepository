package model;

import exception.ValidationException;

public class Doctor extends Person {

    private String specialty;

    public Doctor(int id, String name, int age, String specialty) {
        super(id, name, age, "Doctor");
        setSpecialty(specialty);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        if (specialty == null || specialty.trim().isEmpty()) {
            throw new ValidationException("Specialty cannot be empty.");
        }
        this.specialty = specialty.trim();
    }

    @Override
    public void work() {
        System.out.println("Doctor " + name + " is treating patients.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Specialty: " + specialty;
    }
}
