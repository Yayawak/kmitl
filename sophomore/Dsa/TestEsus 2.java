class University
{
    public static int count = 0;
    public String name;

    public void terminateTerm()
    {
        System.out.println("esus 1");
    }

    public void terminateTerm(int t)
    {

    }
}

class SpecialUni extends University
{
    @Override
    public void terminateTerm()
    {
        super.terminateTerm();
        System.out.println("esus patty stupid 2");
    }
}

public class TestEsus
{
    // constant
    final float pi = 22 /7;

    public static void main(String[] args) {
        University u1 = new University();
        // u1.name = "LKB";
        // University.count++;

        // University u2 = new University();
        // // u1.name = "LKB";
        // University.count++;
        // u1.count == u2.count;
       SpecialUni su1 = new SpecialUni(); 

        // objects == instance
        // u1 u2, u3 
        // u1.terminateTerm();
        // su1.terminateTerm();

        // StringBuilder sb = new StringBuilder("esus patty");
        // sb.append("stupid stupid");

        System.out.println("A" + "B" + "CDDER");
    }
}