import java.util.Stack;

class ExpressionConverion {
    public static String reverseString(String in) {
        if (in.isEmpty())
            return in;
        return reverseString(in.substring(1)) + in.charAt(0);
    }
    private static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
            return true;
        return false;
    }

    private static int getPrecedance(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else {
            return 0;
        }

    }
    public static String infixToPrefix(String infix) {
        String reversedInfix = reverseString(infix);
        // System.out.println(reversedInfix);
        StringBuilder reversedPrefixExpression = new StringBuilder();
        Stack<Character> stC = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                // System.out.print(String.valueOf(c));
                reversedPrefixExpression.append(c);
            }
            else if (c == '(') {
                stC.push(c);
            }
            else if (c == ')') {
                stC.pop();
                while (stC.peek() != ')') {
                    System.out.print(stC.pop());
                }
            }
            else if (isOperator(c)) {
                // stC.add(c);
                if (stC.isEmpty()) {
                    stC.push(c);
                } else {
                    // * priority
                    if (getPrecedance(c) > getPrecedance(stC.peek())) {
                        stC.peek();
                    } else if (getPrecedance(c) == getPrecedance(stC.peek())
                        && c == '^'
                    ) {
                        // !  wtf todo next
                        // stC
                    }
                }

            }
            // stC.add()
        }

        for (int i = 0; i < reversedPrefixExpression.length(); i++) {
            if (!stC.isEmpty()) {
                System.out.println("st : " + String.valueOf(stC.pop()));
            }
            System.out.println("rev pref : " + String.valueOf(
                reversedPrefixExpression.charAt(i)
            ));
            System.out.println("-----------------");
        }
        // while (!stC.isEmpty())
        return "";
    }

    public static void main(String[] args) {
        // String infix = "K + L - M * N";
        // String infix = "K + L * M";
        // * prefix =  "+ K * L M"
        String infix = "K * T + Q";

        String prefix = infixToPrefix(infix);
        System.out.println("infix : " + infix);
        System.out.println("prefix : " + prefix);
    }
}
