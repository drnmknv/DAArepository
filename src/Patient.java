public class Patient extends Person {

    private boolean admitted;

    public Patient(int id, String name, int age, boolean admitted) {
        super(id, name, age, "Patient");
        this.admitted = admitted;
    }

    @Override
    public void work() {
        System.out.println("Patient " + name + " is receiving treatment.");
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    public boolean isAdmitted() {
        return admitted;
    }
}
