import java.util.Scanner;

// public class InputReciever<T> {
public class InputRecieverV0 {
    private static Scanner scanner;
    // public static <T> getInputOnFormat(T t, String instruction) {
    // public static int getInputOnFormat(String instruction) {
    public static <T> T getInputOnFormat(String instruction) {
    // public static String getInputOnFormat(String instruction) {
        scanner = new Scanner(System.in);
        T ret = null;
        boolean valid;
        do {
            // System.out.print("Enter number of column to allocate : ");
            System.out.print(instruction);
            valid = true;
            try {
                String in = scanner.nextLine();
                if (Character.isDigit(in.charAt(0))) {
                    System.out.println("first index is digit");
                    ret = (T)Integer.valueOf(scanner.nextLine());
                    return ret;
                }
                // System.out.println(in.split(" ").length);
                if (in.split(" ").length > 1) {
                    System.out.println("arr : " + in.split(" "));
                    ret = (T)in.split(" ");
                }
                // else {
                //     ret = (T)in;
                // }
                System.out.println("kkk");
                // ((Object)scanner.nextLine()).getClass()
                // if (T instanceof Integer)

                // if ()
                // ret = Integer.valueOf(scanner.nextLine());
                // valid = true;
                return ret;
                // break;
            }
            catch (NumberFormatException e) {
                System.out.println("mismatch input type, enter number.");
                valid = false;
            }
            catch (Exception e) {
                valid = false;
                System.out.println("some critical error");
                e.printStackTrace();
            }
        } while (valid == false);
        scanner.close();
        return ret;
    }
}
