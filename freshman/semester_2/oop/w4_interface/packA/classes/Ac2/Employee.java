package packA.classes.Ac2;

public abstract class Employee {
    protected String name;
    protected int salary;
    protected int experiance;

    // ? CONSTRUCTORS
    public Employee(String n, int exp, int sal) {
        name = n;
        experiance = exp;
        salary = sal;
    }

    public Employee(String n) {
        name = n;
    }

    public Employee() {

    }

    // ? GET SET
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        this.experiance = experiance;
    }

    public abstract void sayHi();
        // System.out.println(String.format("hi from %s", name))


}
