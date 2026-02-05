package menu;

import database.*;
import model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuManager {

    private final Scanner sc = new Scanner(System.in);
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void start() {
        while (true) {
            System.out.println("""
            1 Add Patient
            2 Add Doctor
            3 Add Appointment
            4 View Patients
            5 View Doctors
            6 View Appointments
            7 Search Appointment by Status
            8 Delete Appointment
            9 Exit
            """);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 3 -> {
                    System.out.print("Patient ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Doctor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Status: ");
                    String st = sc.nextLine();
                    appointmentDAO.insert(new Appointment(pid, did, LocalDate.now(), st));
                }
                case 6 -> appointmentDAO.getAll().forEach(System.out::println);
                case 7 -> {
                    System.out.print("Status keyword: ");
                    String k = sc.nextLine();
                    appointmentDAO.searchByStatus(k).forEach(System.out::println);
                }
                case 8 -> {
                    System.out.print("Appointment ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Type YES to confirm: ");
                    if (sc.nextLine().equalsIgnoreCase("YES")) {
                        appointmentDAO.deleteById(id);
                    }
                }
                case 9 -> System.exit(0);
            }
        }
    }
}
