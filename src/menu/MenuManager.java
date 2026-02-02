package menu;

import exception.ValidationException;
import model.Doctor;
import model.Patient;
import model.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final ArrayList<Person> people = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n=== HOSPITAL SYSTEM ===");
        System.out.println("1) Add Patient");
        System.out.println("2) Add Doctor");
        System.out.println("3) View All (Polymorphism)");
        System.out.println("4) View Doctors Only");
        System.out.println("0) Exit");
        System.out.print("Choice: ");
    }

    @Override
    public void run() {
        while (true) {
            try {
                displayMenu();
                int choice = readInt();

                switch (choice) {
                    case 1 -> addPatient();
                    case 2 -> addDoctor();
                    case 3 -> demonstratePolymorphism();
                    case 4 -> viewDoctorsOnly();
                    case 0 -> {
                        System.out.println("Bye!");
                        return;
                    }
                    default -> throw new ValidationException("Choice must be one of: 0,1,2,3,4");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (ValidationException e) {
                System.out.println("Input error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    private int readInt() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private boolean readBoolean() {
        String s = scanner.nextLine().trim().toLowerCase();
        if (!s.equals("true") && !s.equals("false")) {
            throw new ValidationException("Please type true or false.");
        }
        return Boolean.parseBoolean(s);
    }

    private void addPatient() {
        System.out.println("\n--- ADD PATIENT ---");

        System.out.print("Enter ID: ");
        int id = readInt();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = readInt();

        System.out.print("Is admitted? (true/false): ");
        boolean admitted = readBoolean();

        Patient patient = new Patient(id, name, age, admitted);
        people.add(patient);

        System.out.println("Patient added.");
    }

    private void addDoctor() {
        System.out.println("\n--- ADD DOCTOR ---");

        System.out.print("Enter ID: ");
        int id = readInt();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = readInt();

        System.out.print("Enter specialty: ");
        String specialty = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, age, specialty);
        people.add(doctor);

        System.out.println("Doctor added.");
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM ---");
        if (people.isEmpty()) {
            System.out.println("No people yet.");
            return;
        }
        for (Person p : people) {
            p.work(); // abstract method overridden in children
        }
    }

    private void viewDoctorsOnly() {
        System.out.println("\n--- DOCTORS ONLY ---");
        boolean found = false;

        for (Person p : people) {
            if (p instanceof Doctor d) {
                System.out.println(d);
                found = true;
            }
        }

        if (!found) System.out.println("No doctors yet.");
    }
}
