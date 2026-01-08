import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Person> people = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== HOSPITAL SYSTEM ===");
            System.out.println("1. Add Person");
            System.out.println("2. Add Patient");
            System.out.println("3. Add Doctor");
            System.out.println("4. View All (Polymorphism)");
            System.out.println("5. View Doctors Only");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPerson();
                case 2 -> addPatient();
                case 3 -> addDoctor();
                case 4 -> demonstratePolymorphism();
                case 5 -> viewDoctorsOnly();
                case 0 -> running = false;
            }
        }
        scanner.close();
    }

    private static void addPerson() {
        people.add(new Person(1, "Staff", 30, "Staff"));
        System.out.println("Person added.");
    }

    private static void addPatient() {
        people.add(new Patient(2, "Aruzhan", 16, true));
        System.out.println("Patient added.");
    }

    private static void addDoctor() {
        people.add(new Doctor(3, "Dr. Nurlan", 45, "Cardiology"));
        System.out.println("Doctor added.");
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM ---");
        for (Person p : people) {
            p.work();
        }
    }

    private static void viewDoctorsOnly() {
        for (Person p : people) {
            if (p instanceof Doctor) {
                Doctor d = (Doctor) p;
                System.out.println(d + " | " + d.getSpecialty());
            }
        }
    }
}
