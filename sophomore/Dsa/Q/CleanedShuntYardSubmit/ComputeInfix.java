
import java.util.Scanner;

public class ComputeInfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // sc.nextLine();
        System.out.println("Enter you infix notation and i will give you answer from calculation");
        System.out.println("Enter something like this ...");
        System.out.println("5 + 3 * 6 / ( 7 + 1 - 2 * 3 )");
        System.out.println("Start .............");
        String infix = sc.nextLine();

        ShuntingYardInfixNotation infixToPostfixConverter = new ShuntingYardInfixNotation();
        // String infix = "5 + 3";
        // String infix = "5 + 3 4 4 * +";
        // String infix = "3 + 4 * ( 7 - 5 )";
        // String infix = "5 + 3 * 6 / ( 7 + 1 - 2 * 3 )";
        String postfix = infixToPostfixConverter.getReversePolishNotation(infix);
        System.out.println("Postfix from convertion : " + postfix);
        RPN rpn = new RPN();
        System.out.println("Answer from calculation = " + rpn.calculate(postfix));
        System.out.println("End of program now.");
        sc.close();
        System.exit(0);
    }
}
