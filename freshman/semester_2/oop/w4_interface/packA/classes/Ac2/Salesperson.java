package packA.classes.Ac2;

import packA.interfaces.SalesRoles;

public class Salesperson extends Employee implements SalesRoles {
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
        super.setSalary((int)(getSalary() * 1.1));
    }

    @Override
    public void setSalary(int increasedAmount) {
        super.setSalary(getSalary() + increasedAmount);
    }

    // @Override
    // public String makeQuotation() {
    //     int i = (int)(Math.random() * 100);
    //     String str = String.format(" Dear value customer, %d is my best offer.  ", i);
    //     return str;
    // }
    @Override
    public void sayHi() {
        String ret = "Hi from this Sales person";
        System.out.println(ret);
    }

    @Override
    public String makeQuatation() {
        int i = (int)(Math.random() * 100);
        String str = String.format(" Dear value customer, %d is my best offer.  ", i);
        return str;
    }
}
