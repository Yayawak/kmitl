package packA;

public class Salesperson extends EmpTmp {
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

    public String makeQuotation() {
        int i = (int)(Math.random() * 100);
        String str = String.format(" Dear value customer, %d is my best offer.  ", i);
        return str;
    }

    @Override
    public String toString() {
        String str = String.format("Salesperson [ target=%d Programmer [name=%s, salary=%d, experiance=%d] ]"
            ,target, getName(), getSalary(), getExperiance()
            );
        return str;
    }
}
