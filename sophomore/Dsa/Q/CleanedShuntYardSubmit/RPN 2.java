
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class RPN {
    private static Pattern numberPattern = Pattern.compile(
        "-?\\d+(\\.\\d+)?");
    StackArrayGeneric<Double> stack = new StackArrayGeneric<>();

    public RPN()
    {
    }

    private boolean isNumber(String s) 
    {
        if (s == null) return false;
        return numberPattern.matcher(s).matches();
    }

    public double calculate(String reversedPolishExpressino)
    {
        StringTokenizer stk = new StringTokenizer(reversedPolishExpressino, " ");
        while (stk.hasMoreTokens())
        {
            String token = stk.nextToken();
            if (isNumber(token))
            {
                stack.push(Double.parseDouble(token));
            }
            else
            {
                // ? This is wrong order poping
                // double a = stack.pop();
                // double b = stack.pop();

                // ! Order of Poping is crucial
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                
                    default:
                        break;
                }
            }
            // System.out.println(token);
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String testString = "5 3 * 2 2 + -";
        RPN rpn = new RPN();
        double output = rpn.calculate(testString);
        System.out.println("output of calculation: " + output);
    }
}
