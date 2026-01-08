public class Person {

    protected int id;
    protected String name;
    protected int age;
    protected String role;

    public Person(int id, String name, int age, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

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
