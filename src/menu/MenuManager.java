package menu;

import database.AppointmentDAO;
import model.Appointment;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuManager {

    private final Scanner sc = new Scanner(System.in);
    private final AppointmentDAO dao = new AppointmentDAO();

    public void start() {
        while (true) {
            System.out.println("""
            1 Add appointment
            2 View all appointments
            3 Update appointment status
            4 Delete appointment
            5 Search by status
            6 Search by date range
            7 View upcoming appointments
            8 View completed appointments
            9 View today's appointments
            10 View past appointments
            11 Exit
            """);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    System.out.print("Status: ");
                    String status = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    dao.insert(new Appointment(date, status, desc));
                }

                case 2 -> dao.getAll().forEach(System.out::println);

                case 3 -> {
                    System.out.print("Appointment ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New status: ");
                    dao.updateStatus(id, sc.nextLine());
                }

                case 4 -> {
                    System.out.print("Appointment ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Type YES to confirm deletion: ");
                    if (sc.nextLine().equalsIgnoreCase("YES")) {
                        dao.deleteById(id);
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Cancelled.");
                    }
                }

                case 5 -> {
                    System.out.print("Status keyword: ");
                    dao.searchByStatus(sc.nextLine()).forEach(System.out::println);
                }

                case 6 -> {
                    System.out.print("From date: ");
                    LocalDate from = LocalDate.parse(sc.nextLine());
                    System.out.print("To date: ");
                    LocalDate to = LocalDate.parse(sc.nextLine());
                    dao.searchByDateRange(from, to).forEach(System.out::println);
                }

                case 7 -> dao.searchByDateRange(LocalDate.now(), LocalDate.now().plusYears(10))
                        .forEach(System.out::println);

                case 8 -> dao.searchByStatus("completed").forEach(System.out::println);

                case 9 -> dao.searchByDateRange(LocalDate.now(), LocalDate.now())
                        .forEach(System.out::println);

                case 10 -> dao.searchByDateRange(LocalDate.of(2000,1,1), LocalDate.now())
                        .forEach(System.out::println);

                case 11 -> System.exit(0);
            }
        }
    }
}
