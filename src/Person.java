public class Person {

    protected int id;
    protected String name;
    protected int age;
    protected String role;

    public Person(int id, String name, int age, String role) {
        setId(id);
        setName(name);
        setAge(age);
        this.role = role;
    }

    // ====== VALIDATION
    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            this.id = 0;
            System.out.println("Invalid ID, set to 0");
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
            System.out.println("Invalid name, set to 'Unknown'");
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
            System.out.println("Invalid age, set to 0");
        }
    }

    // ====== METHODS TO OVERRIDE ======
    public void work() {
        System.out.println(name + " is working.");
    }

    public String getRole() {
        return role;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "[" + role + "] " + name + " (Age: " + age + ")";
    }
}
