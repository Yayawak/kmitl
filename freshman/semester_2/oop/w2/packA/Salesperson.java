package packA;
import packA.Programmer;

public class Salesperson extends Programmer{
    private int target;

    public Salesperson(String n, int exp, int sal, int assignedTarget) {
        super(n, exp, sal);
        setTarget(assignedTarget);
    }

    public Salesperson(String n, int exp) {
        super.setName(n);
        super.setExperiance(exp);
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    // @Override
    public void setSalary() {
        // this.setSalary(getSalary() * 1.1);
        // salary = (int)(getSalary() * 1.1);
        super.setSalary((int)(getSalary() * 1.1));
    }

    public void setSalary(int increasedAmount) {
        super.setSalary(getSalary() + increasedAmount);
    }

    // public void makeQuotation() {
    public String makeQuotation() {
        int i = (int)(Math.random() * 100);
        // System.out.println(i);
        String str = String.format(" Dear value customer, %d is my best offer.  ", i);
        // System.out.println(String.format(" Dear value customer, %d is my best offer.  "));
        return str;
    }

    public void sayHi() {
        System.out.println(String.format("hi from %s", getName()));
    }

    @Override
    public String toString() {
        // return "Salesperson [target=" + target + "]";

        String str = String.format("Salesperson [ target=%d Programmer [name=%s, salary=%d, experiance=%d] ]"
            ,target, getName(), getSalary(), getExperiance()
            );
        return str;
    }
}
