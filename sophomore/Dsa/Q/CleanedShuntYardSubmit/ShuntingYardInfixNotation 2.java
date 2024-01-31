
import java.util.StringTokenizer;
import java.util.regex.Pattern;

class Utils
{
    private static Pattern numberPattern = Pattern.compile(
        "-?\\d+(\\.\\d+)?");

    public static boolean isNumber(String s) 
    {
        if (s == null) return false;
        return numberPattern.matcher(s).matches();
    }
}

public class ShuntingYardInfixNotation {

    private StackBehaviorGeneric<Character> operatorStack;
    private QLinkedList<String> outputQ;

    private boolean isOperator(char o)
    {
        // return "+-*/".contains(String.valueOf(o));
        return o == '+' || o == '-' || o == '*' || o == '/';
    }

    private boolean isOperatorAImportantThanB(char a, char b)
    {
        assert isOperator(a);
        assert isOperator(b);
        return (priorityOfOperator(a) < priorityOfOperator(b));
    }

    private int priorityOfOperator(char operator)
    {
        assert isOperator(operator);
        // assert operator != '(';
        // assert operator != ')';

        switch (operator)
        {
            case '-':
                return 4;
            case '+':
                return 3;
            case '/':
                return 2;
            case '*':
                return 1;
            // default:
            //     // return 888;
            //     // System.out.println("Error unsupported operators : " + operator);
            //     // assert false;
            // //     // System.exit(operator);
            //     return 999;
        }
        // System.out.println("Error unsupported operators : " + operator);
        return 999;
    }

    public String getReversePolishNotation(String infixNotation)
    {
        StringTokenizer tokenizer = new StringTokenizer(infixNotation, " ");
        // int n_tokens = tokenizer.countTokens();
        // operatorStack = new StackArrayGeneric<>(n_tokens);        
        operatorStack = new StackArrayGeneric<>(20);        
        // operatorStack = new StackLink
        outputQ = new QLinkedList<>();

        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();

            if (Utils.isNumber(token))
                outputQ.enq(token);
            else if (token.equals("("))
                operatorStack.push('(');
            else if (isOperator(token.charAt(0)))
            // else if (char thisOperator && (thisOperator = token.charAt(0)) && isOperator(thisOperator))
            {
                while (!operatorStack.isEmpty() && isOperatorAImportantThanB(operatorStack.top(), token.charAt(0)))
                {
                    outputQ.enq(String.valueOf(operatorStack.pop()));
                }
                operatorStack.push(token.charAt(0));
            }
            else if (token.equals(")"))
            {
                // String out;
                // while (!(out = operatorStack.pop()).equals("("))
                while (operatorStack.top() != '(')
                {
                    outputQ.enq(String.valueOf(operatorStack.pop()));
                }
                // ? After end of while loop the top of the stack is (
                // * So we get rid of (
                operatorStack.pop();
            }
            else
            {
                System.err.println("Unexpected token : Neiter number or operator or ( or ).");
                System.exit(-3);
            }
            
        }

        // * clear remaining operators in stack
        while (!operatorStack.isEmpty() && isOperator(operatorStack.top()))
        {
            outputQ.enq(String.valueOf(operatorStack.pop()));
        }
        
        //SECTION : convert from output Q to rpn expression
        StringBuilder sb = new StringBuilder("");
        while (!outputQ.isEmpty())
            sb.append(outputQ.deq() + " ");
        return sb.toString();
    }
}
