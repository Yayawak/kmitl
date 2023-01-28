// package kmitl.f
package packA;

public class Programmer extends EmpTmp {

    public Programmer(String n, int exp, int sal) {
        name = n;
        experiance = exp;
        salary = sal;
    }

    @Override
    public void sayHi() {
        String str = String.format("hi from %s", name);
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Programmer [name=" + name + ", salary=" + salary + ", experiance=" + experiance + "]";
    }

    public String coding() {
        String ret = String.format("%s is coding now.", name);
        return ret;
    }

}
