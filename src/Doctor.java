public class Doctor extends Person {

    private String specialty;

    public Doctor(int id, String name, int age, String specialty) {
        super(id, name, age, "Doctor");
        setSpecialty(specialty);
    }

    public void setSpecialty(String specialty) {
        if (specialty != null && !specialty.trim().isEmpty()) {
            this.specialty = specialty;
        } else {
            this.specialty = "General";
            System.out.println("Invalid specialty, set to 'General'");
        }
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
