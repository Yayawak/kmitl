// package kmitl.f
package packA;

public class Programmer {
    private String name;
    protected int salary;
    private int experiance;

    public Programmer() {

    }

    public Programmer(String n) {
        name = n;
    }


    public Programmer(String n, int exp, int sal) {
        name = n;
        experiance = exp;
        salary = sal;
    }

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

    public void sayHi() {
        String str = String.format("hi from %s", name);
        System.out.println(str);
    }

    @Override
    public String toString() {
        // super().toString();
        return "Programmer [name=" + name + ", salary=" + salary + ", experiance=" + experiance + "]";
    }

}
