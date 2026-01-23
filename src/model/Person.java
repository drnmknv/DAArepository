package model;

import exception.ValidationException;

public abstract class Person {

    protected int id;
    protected String name;
    protected int age;
    protected final String role;

    protected Person(int id, String name, int age, String role) {
        setId(id);
        setName(name);
        setAge(age);
        if (role == null || role.trim().isEmpty()) {
            throw new ValidationException("Role cannot be empty.");
        }
        this.role = role.trim();
    }

    // ====== GETTERS ======
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getRole() { return role; }

    // ====== SETTERS ======
    public void setId(int id) {
        if (id <= 0) throw new ValidationException("ID must be a positive number.");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 2) {
            throw new ValidationException("Name must be at least 2 characters.");
        }
        this.name = name.trim();
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new ValidationException("Age must be between 0 and 120.");
        }
        this.age = age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    // ====== REQUIRED ABSTRACT METHOD ======
    public abstract void work();

    @Override
    public String toString() {
        return "[" + role + "] " + name + " (ID: " + id + ", Age: " + age + ")";
    }
}
