import java.util.Stack;

class Conversion
{
    private Stack<Character> charStk;
    private String infix;
    private String output = "";

    public Conversion(String infix)
    {
        this.infix = infix;
        charStk = new Stack<>();
    }

    public String inToPost()
    {
        for (int i = 0; i < infix.length(); i++)
        {
            char ch = infix.charAt(i);
            switch (ch)
            {
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '(':
                    charStk.push(ch);
                    break;
                case ')':
                    gotParenthesis();
                    break;
                default:
                    output = output + ch;
            }
        }
        while (!charStk.isEmpty())
            output = output + charStk.pop();
        return output;
    }
    private void gotOperator(char opThis, int prec1)
    {
        while (!charStk.isEmpty())
        {
            char opTop = charStk.pop();
            if (opTop == '(')
            {
                charStk.push(opTop);
                break;
            } else
            {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1)
                {
                    charStk.push(opTop);
                    break;
                } else
                    output = output + opTop;
            }
        }
        charStk.push(opThis);
    }

    private void gotParenthesis()
    {
        while (!charStk.isEmpty())
        {
            char ch = charStk.pop();
            if (ch == '(')
                break;
            else
                output = output + ch;
        }
    }
}
