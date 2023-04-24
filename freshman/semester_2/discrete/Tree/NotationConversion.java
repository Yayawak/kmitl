import java.rmi.ConnectIOException;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.RunElement;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import apple.laf.JRSUIConstants.State;

class NotationConversion {
    private static char[] operatorSet = {'+', '-', '*', '/', '^'};
    // public static void main(String[] args) {
    //     String infix = "1 + 3 * 5";
    //     // String infix = "1+3";
    //     String ret = infixToPrefixPostfix(infix, "prefix");
    //     System.out.println("infix : " + infix);
    //     System.out.println("prefix : " + ret);
    //     System.out.println("postfix : " + infixToPrefixPostfix(infix, "postfix"));
    // }

    private static boolean isOperator(char c) {
        for (char operator : operatorSet) {
            if (operator == c)
                return true;
        }
        return false;
    }

    private static int getPrecedence(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 0;
    }

    public static String infixToPrefixPostfix(String infix, String notation) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int i;
        int j;
        char c;
        char op;

        if (notation.equals("prefix"))
            //  *String infix = "1 + 3 * 5";
            infix = new StringBuilder(infix).reverse().toString();
            // * infix = "5 * 3 + 1"
        for (i = 0; i < infix.length(); i++) {
            c = infix.charAt(i);
            if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    op = stack.pop();
                    if (notation.equals("prefix"))
                        result.append(op);
                    else
                        result.insert(0, op);
                }
                // * pop left (
                stack.pop();
            }
            else if (c == ')') {
                stack.push('c');
            }
            else if (isOperator(c)) {
                while (!stack.isEmpty()
                    && stack.peek() != ')'
                    && getPrecedence(c) <= getPrecedence(stack.peek())
                    ) {
                    op = stack.pop();
                    if (notation.equals("prefix"))
                        result.append(op);
                    else
                        result.insert(0, op);
                }
                stack.push(c);
            }
            // * hanlding operand
            else {
                if (notation.equals("prefix"))
                    result.append(c);
                else
                    result.insert(0, c);
            }
        }

        // * handling remainng operators
        while (!stack.empty()) {
            op = stack.pop();
            if (notation.equals("prefix"))
                result.append(op);
            else
                result.insert(0, op);
        }
        return result.toString();
    }

    // public static String infixToPrefixPostfix(String infix, String notation) {
    //     int n = infix.length();
    //     char c;
    //     // * base case : single operand
    //     if (n == 0)
    //         return "";
    //     if (n == 1)
    //         if (notation.equals("prefix"))
    //             return infix;
    //         else
    //             return "";
    //     int index = -1;
    //     int minPrecedence = Integer.MAX_VALUE;
    //     int countParentheses = 0;
    //     for (int i = 0; i < n; i++) {
    //         c = infix.charAt(i);
    //         if (c == '(')
    //             countParentheses++;
    //         else if (c == ')')
    //             countParentheses--;
    //         else if (countParentheses == 0
    //             && isOperator(c)
    //             && getPrecedence(c) <= minPrecedence
    //             ) {
    //             index = i;
    //             minPrecedence = getPrecedence(c);
    //         }
    //     }
    //     // * divind
    //     String leftOperand = infixToPrefixPostfix(
    //         infix.substring(0, index).replace("\\s", ""),
    //         notation
    //     );
    //     String rightOperand = infixToPrefixPostfix(
    //         infix.substring(index + 1).replace("\\s", ""),
    //         notation
    //     );
    //     // * merge
    //     String operator = infix.substring(index, index + 1);
    //     if (notation.equals("prefix"))
    //         return operator + leftOperand + rightOperand;
    //     else
    //         return leftOperand + rightOperand + operator;

    // }

}
