package SuperComputer;
import java.util.List;
import java.util.Scanner;


public class SuperComputer
{
    private final String lowerCharSet = "abcdefghijklmnopqrstuvwxyz";
    private char[] lowerInput;
    private int n;

    static char currentCharaterToCheckIfExist;
    static int k = 0;

    private static Scanner sc = new Scanner(System.in);;

    public static int getNumInput()
    // public static <T>  T getInput()
    {
        // T dynamicVariable;

        // System.out.format("Enter you number in terminal : \n");
        // System.out.format("Enter you input in terminal : \n");
        try {
            String input = sc.nextLine();
            int num = Integer.parseInt(input); // for try catch
            // if (in)


            return (num);
        } 
        catch (NumberFormatException e)
        {
            System.out.println("You must enter a number, not a string.");
            return getNumInput();
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return (-666);
    }

    // NOTE
    public static String getOnlyLowerCaseStringInput()
    {
        // System.out.println("Enter valid string ... ");
        String rawString = sc.nextLine();
        // check if all characters are "alphabetic & lowercase"
        for (int i = 0; i < rawString.length(); i++)
        {
            char c = rawString.charAt(i);
            if (!(Character.isAlphabetic(c) && Character.isLowerCase(c)))
            {
                System.out.println("Error found : input only alphabet & lowercase characters");
                return getOnlyLowerCaseStringInput();
            }
        }
        return (rawString);
    }

    public static void closeScanner()
    {
        sc.close();
    }

    public SuperComputer(int n, String lowerInput)
    {
        this.n = n;
        this.lowerInput = lowerInput.toCharArray();
        // System.out.println("array char : " + lowerInput);

        currentCharaterToCheckIfExist = lowerCharSet.charAt(k);

        // startProcess();
    }

    // private boolean isCharacterExistInCharSet(char[] cs, char c)
    private int indexCharacterExistInCharSet(char[] cs, char c)
    {
        // System.out.format("c = %c\tlen(cs) = %d\n", c , cs.length);
        for (int i = 0; i < cs.length; i++)
            if (cs[i] == c)
            {
                // System.out.println("Found");
                // return true;
                return i;
            }
        return -1;
    }

    private String getCleanedInput()
    {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < lowerInput.length; i++)
        {
            if (lowerInput[i] != '5')
                sb.append(lowerInput[i]);
        }
        if (sb.toString() == "")
            return "All Disappeared!!!";
        return sb.toString();
    }

    private void startProcess()
    {
        int idx;
        n--;
        while (n >= 0)
        {
            while (true)
            {
                if (
                    (idx = indexCharacterExistInCharSet(lowerInput, currentCharaterToCheckIfExist)) != -1
                    || currentCharaterToCheckIfExist == 'z'
                )
                {
                    lowerInput[idx] = '5';
                    break;
                }
                currentCharaterToCheckIfExist++;
            }
            n--;
        }
        
    }


    public static void main(String[] args) 
    {
        int n = SuperComputer.getNumInput();
        // System.out.println("n = " + n);

        String cleanedLowerString = SuperComputer.getOnlyLowerCaseStringInput();
        // System.out.println(cleanedLowerString);

        if (n > cleanedLowerString.length())
            return;

        var spc = new SuperComputer(n, cleanedLowerString);
        spc.startProcess();
        // System.out.println(spc.getCleanedInput());


        SuperComputer.closeScanner();

        // c2, a5, b2, d3
        // String dummyLowerString = "ccaaaaaabbdd";
        // String dummyLowerString = "zzzwxabacaca";
        // var spc = new SuperComputer(6, dummyLowerString);

        // String dummyLowerString = "cccaabababaccbc";
        // var spc = new SuperComputer(3, dummyLowerString);

        // String dummyLowerString = "u";
        // var spc = new SuperComputer(1, dummyLowerString);
        // char testChar = 'c';
        // System.out.println(spc.isCharacterExistInCharSet(dummyLowerString.toCharArray(), testChar));
        // System.out.println(dummyLowerString);
        // spc.startProcess();
        System.out.println(cleanedLowerString);
        System.out.println(spc.lowerInput);
        System.out.println(spc.getCleanedInput());

    }
}