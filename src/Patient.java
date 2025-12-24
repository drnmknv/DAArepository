// Name: Daryn
// Course: Object Oriented Programming
// Project: Hospital Management System
//s
public class Patient {
    private int id;
    private String name;
    private int age;
    private boolean admitted;
    private String bloodType;

    public Patient() {
        this.id = 0;
        this.name = "Unknown";
        this.age = 0;
        this.admitted = false;
        this.bloodType = "Unknown";
    }

    public Patient(int id, String name, int age, boolean admitted, String bloodType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.admitted = admitted;
        this.bloodType = bloodType;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getAge() { return this.age; }
    public boolean isAdmitted() { return this.admitted; }
    public String getBloodType() { return this.bloodType; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public void setAdmitted(boolean admitted) { this.admitted = admitted; }

    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public boolean isMinor() {
        return this.age < 18;
    }

    public void toggleAdmit() {
        this.admitted = !this.admitted;
    }

    @Override
    public String toString() {
        return "Patient{id=" + this.id +
                ", name='" + this.name + '\'' +
                ", age=" + this.age +
                ", admitted=" + this.admitted +
                ", bloodType='" + this.bloodType + '\'' +
                '}';
    }
}
