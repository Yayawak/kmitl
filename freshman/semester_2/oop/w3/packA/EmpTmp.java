package packA;

public class EmpTmp {
    protected String name;
    protected int salary;
    protected int experiance;

    // ? CONSTRUCTORS
    public EmpTmp(String n, int exp, int sal) {
        name = n;
        experiance = exp;
        salary = sal;
    }

    public EmpTmp(String n) {
        name = n;
    }

    public EmpTmp() {

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

    // ? UTILITIES
    @Override
    public String toString() {
        return "EmpTmp [name=" + name + ", salary=" + salary + ", experiance=" + experiance + "]";
    }

    public void sayHi() {
        System.out.println(String.format("hi from %s", name));
    }


}
