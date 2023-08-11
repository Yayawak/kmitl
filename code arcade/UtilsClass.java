import java.util.Scanner;

class UtilsClass
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static Scanner sc = new Scanner(System.in);;

    public static String getPrettyIntArray(int[] A)
    {
        StringBuilder sb = new StringBuilder("[");
        int i;
        for (i = 0; i < A.length - 1; i++)
            sb.append(A[i] + ", ");
        sb.append(A[i]);
        sb.append("]");
        return sb.toString();
    }

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

    public static void closeScanner()
    {
        sc.close();
    }

}