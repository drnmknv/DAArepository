// Name: Daryn
// Course: Object Oriented Programming
// Project: Hospital Management System
//s
public class Main {
    public static void main(String[] args) {

        System.out.println("=== Hospital Management System ===\n");

        // CREATE OBJECTS
        Patient p1 = new Patient(1, "Aruzhan", 16, false, "O+");
        Patient p2 = new Patient(2, "Dias", 34, true, "A-");
        Patient p3 = new Patient();

        Doctor d1 = new Doctor(10, "Dr. Nurlan", "Cardiology", 12, true);
        Doctor d2 = new Doctor();

        Appointment a1 = new Appointment(100, 1, 10, "2026-01-10", false, "Scheduled");
        Appointment a2 = new Appointment();

        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println("--- Initial Objects ---");
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println(" --------------");


        System.out.println("Patient 1: " + p1);
        System.out.println("Patient 2: " + p2);
        System.out.println("Patient 3: " + p3);
        System.out.println("Doctor 1: " + d1);
        System.out.println("Doctor 2: " + d2);
        System.out.println("Appointment 1: " + a1);
        System.out.println("Appointment 2: " + a2);

        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println("Updating Objects");
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println(" --------------");

        // getters
        System.out.println("p1 name: " + p1.getName());
        System.out.println("p1 age: " + p1.getAge());
        System.out.println("p1 blood type: " + p1.getBloodType());
        System.out.println("d1 specialty: " + d1.getSpecialty());
        System.out.println("a1 date: " + a1.getDate());

        //setters

        p3.setId(3);
        p3.setName("Zarina");
        p3.setAge(70);
        p3.setAdmitted(true);
        p3.setBloodType("B+");

        d2.setId(11);
        d2.setName("Dr. Alina");
        d2.setSpecialty("Surgery");
        d2.setYearsExperience(6);
        d2.setOnDuty(false);

        a2.setId(101);
        a2.setPatientId(2);
        a2.setDoctorId(11);
        a2.setDate("2026-01-12");
        a2.setStatus("Scheduled");

        System.out.println("Updated Patient 3: " + p3);
        System.out.println("Updated Doctor 2: " + d2);
        System.out.println("Updated Appointment 2: " + a2);

        // TEST METHODS
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println("Testing Methods");
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println(" --------------");

        System.out.println("Is " + p1.getName() + " a minor? " + p1.isMinor());
        p2.toggleAdmit();
        System.out.println(p2.getName() + " admitted after toggle: " + p2.isAdmitted());

        System.out.println("Is " + d1.getName() + " senior? " + d1.isSeniorDoctor());
        d2.addYear();
        System.out.println(d2.getName() + " experience after addYear: " + d2.getYearsExperience());

        a1.reschedule("2026-01-15");
        a1.markDone();
        System.out.println("Appointment 1 after updates: " + a1);
        // FINAL OUTPUT
        System.out.println("\n--- Final State ---");
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println(" --------------");
        System.out.println("CHETKO");
    }
}
