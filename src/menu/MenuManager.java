package menu;

import database.AppointmentDAO;
import model.Appointment;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuManager implements Menu {

    // vspomogatelnoe
    private int i(String p) {
        while (true) {
            System.out.print(p);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Enter a number."); }
        }
    }
    private String s(String p) {
        System.out.print(p);
        return sc.nextLine().trim();
    }
    private LocalDate d(String p) {
        while (true) {
            System.out.print(p);
            try { return LocalDate.parse(sc.nextLine().trim()); }
            catch (DateTimeParseException e) { System.out.println("Format: YYYY-MM-DD"); }
        }
    }
    private void print(Iterable<?> items) {
        boolean any = false;
        for (Object x : items) { System.out.println(x); any = true; }
        if (!any) System.out.println("(no results)");
    }
    private final Scanner sc = new Scanner(System.in);
    private final AppointmentDAO dao = new AppointmentDAO();

    @Override
    public void displayMenu() {
        System.out.println("""
                1 Add | 2 All | 3 Update status | 4 Delete
                5 Search status | 6 Date range | 7 Upcoming
                8 Completed | 9 Today | 10 Past | 11 ID range
                0 Exit
                """);
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            int c = i("Choose: ");

            switch (c) {
                case 1 -> add();
                case 2 -> print(dao.getAll());
                case 3 -> update();
                case 4 -> delSafe();
                case 5 -> print(dao.searchByStatus(s("Status keyword: ")));
                case 6 -> print(dao.searchByDateRange(d("From (YYYY-MM-DD): "), d("To (YYYY-MM-DD): ")));
                case 7 -> print(dao.searchByDateRange(LocalDate.now(), LocalDate.now().plusYears(10)));
                case 8 -> print(dao.searchByStatus("completed"));
                case 9 -> { LocalDate t = LocalDate.now(); print(dao.searchByDateRange(t, t)); }
                case 10 -> print(dao.searchByDateRange(LocalDate.of(2000, 1, 1), LocalDate.now().minusDays(1)));
                case 0 -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    public void start() { run(); }

    // methods

    private void add() {
        boolean ok = dao.insert(new Appointment(d("Date (YYYY-MM-DD): "), s("Status: "), s("Description: ")));
        System.out.println(ok ? "Added." : "Insert failed.");
    }

    private void update() {
        int id = i("ID: ");
        Appointment a = dao.getById(id);
        if (a == null) { System.out.println("Not found."); return; }
        System.out.println("Current: " + a);
        System.out.println(dao.updateStatus(id, s("New status: ")) ? "Updated." : "Update failed.");
    }

    private void delSafe() {
        int id = i("ID: ");
        Appointment a = dao.getById(id);
        if (a == null) { System.out.println("Not found."); return; }
        System.out.println("Will delete: " + a);
        if (!s("Type YES: ").equalsIgnoreCase("YES")) { System.out.println("Cancelled."); return; }
        System.out.println(dao.deleteById(id) ? "Deleted." : "Delete failed.");
    }
}