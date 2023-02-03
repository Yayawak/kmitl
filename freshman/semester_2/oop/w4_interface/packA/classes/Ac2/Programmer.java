package packA.classes.Ac2;

import java.util.ArrayList;


public class Programmer extends Employee {

    protected ArrayList<String> skills = new ArrayList<>();
    // private ArrayList<String> skills = new ArrayList<>();

    public Programmer(String n, int exp, int sal, String... skills) {
        name = n;
        experiance = exp;
        salary = sal;

        for (String skill : skills)
            this.skills.add(skill);
    }

    @Override
    public void sayHi() {
        String str = String.format("hi from Programmer %s", name);
        System.out.println(str);
        // System.out.println(this.coding());
        // System.out.println(coding());
    }


    public String coding() {
        String ret = String.format("%s is coding now.", name);
        ret += "\nI can code in\n...";
        ret += "[";
        for (String skill : skills) {
            ret += skill + ", ";
        }
        ret += "]";
        return ret;
    }

}
