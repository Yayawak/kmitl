import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class FtoCInputCheck {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        double fahrenheit, celsius;
        String fahStr;
        System.out.print("Please enter degree in fahrenheit ");
        fahStr = inp.nextLine();
        if (validateInput(fahStr)) {
            fahrenheit = Double.parseDouble(fahStr);
            celsius = (5.0/9.0) * (fahrenheit - 32);
            System.out.printf("%6.2f fahrenheit is %6.2f celsius\n", fahrenheit, celsius);
        }
        else {
            System.err.println("Your input is not valid");
        }
        System.out.println("Good Bye");
        inp.close();
    }
    public static boolean validateInput(String str) {
        Pattern p = Pattern.compile("[0-9]+[.]?[0-9]*");
        Matcher m = p.matcher(str);
        if (m.matches()) {
            return true;
        }
        return false;
    }
}
