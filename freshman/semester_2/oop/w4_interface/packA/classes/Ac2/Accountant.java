package packA.classes.Ac2;

public class Accountant extends Employee {
    private static String companyName = "berk barn jamkad";
    private int experiance;
    private String specialty;

    public Accountant(String name, int superExp, int experiance,
        int salary, String talent
    ) {
        super(name, superExp, salary);
        this.experiance = experiance;
        this.specialty = talent;
    }

    public void setSpecialty(String newSpecialty) {
        specialty = newSpecialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setAccountExperiance(int exp) {
        this.experiance = exp;
    }

    public int getAccountExperiance() {
        return this.experiance;
    }

    public String tellProfit() {
        int rand = (int)(Math.random() * 100);
        String str = String.format("""
            %s's profit is %d, My salary is %d
        """,
            companyName, rand, salary
        );
        return str;
    }

    @Override
    public String toString() {
        String str = String.format("""
            %s %d %d can %s
        """, getName(), super.getExperiance(),
            this.experiance, this.specialty
        );
        return str;
    }

    @Override
    public void sayHi() {
        int rand = (int)(Math.random() * 100);
        String str = String.format("""
            %s's profit is %d. My salary is %d
        """
        , companyName, rand, salary);
        System.out.println(str);
    }

    public static String tellMyRole() {
        String str = String.format("I am an accountant at %s\n",
            companyName
        );
        return str;
    }
}
