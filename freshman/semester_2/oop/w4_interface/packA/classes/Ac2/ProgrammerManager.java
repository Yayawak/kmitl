package packA.classes.Ac2;
import packA.interfaces.MangerRoles;

public class ProgrammerManager extends Programmer implements MangerRoles {
    public ProgrammerManager(String n, int exp, int sal, String... skills) {
        super(n, exp, sal, skills);
    }


    @Override
    public String coding() {
        String ret = String.format("%s is coding now.", name);
        ret += "\nI\'m Programmer manager";
        ret += "\nI can code in...";
        ret += skills;
        return ret;
    }

    @Override
    public void sayHi() {
        // String str = String.format("hi from ProgrammerManager %s", name);

        // System.out.println(str);
        System.out.println(coding());
    }

    @Override
    public int evaluate(Programmer p) {
        p.setSalary((int)Math.ceil(p.getSalary() * 1.15));
        return p.getSalary();
    }

    @Override
    public String toString() {
        return String.format("ProgrammerManager [name=%s, experiance=%d, salary=%d]",
            getName(), getExperiance(), getSalary());
    }
}
