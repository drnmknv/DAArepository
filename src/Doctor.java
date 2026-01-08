public class Doctor extends Person {

    private String specialty;

    public Doctor(int id, String name, int age, String specialty) {
        super(id, name, age, "Doctor");
        this.specialty = specialty;
    }

    @Override
    public void work() {
        System.out.println("Doctor " + name + " is treating patients.");
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    public String getSpecialty() {
        return specialty;
    }
}
