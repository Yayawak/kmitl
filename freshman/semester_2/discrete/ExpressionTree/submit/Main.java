import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        String ch = "y";
        Scanner sc = new Scanner(System.in);
        while (ch.equals("y"))
        {
            ExpressionTree t = new ExpressionTree();
            System.out.println("Enter the Expression");
            String infix = sc.nextLine();
            t.insert(infix);

            System.out.println("type 1 : prefix form");
            System.out.println("type 2 : infix form");
            System.out.println("type 3 : prefix form");
            System.out.println("choose type [123] ...");
            int type = Integer.valueOf(sc.nextLine());
            t.traverse(type);
            System.out.println();
            System.out.println("print prefix tree");
            t.printTree();

            System.out.println("Enter y to continue");
            ch = sc.nextLine();
        }
        sc.close();
    }
}
