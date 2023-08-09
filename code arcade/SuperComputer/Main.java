package SuperComputer;
import java.util.Scanner;


public class Main
{
    private final String lowerCharSet = "abcdefghijklmnopqrstuvwxyz";
    private char[] lowerInput;
    private int n;

    static char currentCharaterToCheckIfExist;
    static int k = 0;

    private static Scanner sc = new Scanner(System.in);;

    public static int getNumInput()
    {
        try {
            String input = sc.nextLine();
            int num = Integer.parseInt(input); // for try catch
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

    public static String getOnlyLowerCaseStringInput()
    {
        String rawString = sc.nextLine();
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

    public Main(int n, String lowerInput)
    {
        this.n = n;
        this.lowerInput = lowerInput.toCharArray();
        currentCharaterToCheckIfExist = lowerCharSet.charAt(k);
    }

    private int indexCharacterExistInCharSet(char[] cs, char c)
    {
        for (int i = 0; i < cs.length; i++)
            if (cs[i] == c)
                return i;
        return -1;
    }

    private String getCleanedInput()
    {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < lowerInput.length; i++)
            if (lowerInput[i] != '5')
                sb.append(lowerInput[i]);
        if (sb.length() == 0)
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
        int n = Main.getNumInput();
        String cleanedLowerString = Main.getOnlyLowerCaseStringInput();
        if (n > cleanedLowerString.length())
            return;
        Main spc = new Main(n, cleanedLowerString);
        spc.startProcess();
        SuperComputer.closeScanner();

        // System.out.println(cleanedLowerString);
        // System.out.println(spc.lowerInput);
        System.out.println(spc.getCleanedInput());

    }
}