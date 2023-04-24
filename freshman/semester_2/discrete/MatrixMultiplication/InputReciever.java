import java.util.Scanner;

public class InputReciever {
    private static Scanner scanner = new Scanner(System.in);

    public static int[] getIntArrInput(String instruction, int n) {
        boolean valid;
        int arr[] = new int[n];
        do {
            System.out.print(instruction);
            valid = true;
            try {
                String[] strArr = scanner.nextLine().split(" ");
                if (strArr.length != n) {
                    System.out.println("number of element must be " + n);
                    valid = false;
                    continue;
                }
                arr = new int[strArr.length];
                for (int i = 0; i < strArr.length; i++)
                    arr[i] = Integer.valueOf(strArr[i]);
            }
            catch (NumberFormatException e) {
                valid = false;
                System.out.println("Number format mismatch.");
            }
            catch (Exception e) {
                valid = false;
                System.out.println(e);
            }

        } while (valid == false);
        return arr;
    }

    public static int getIntInput(String instruction) {
        boolean valid;
        int num = -999;
        do {
            System.out.print(instruction);
            valid = true;
            try {
                num = Integer.valueOf(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                valid = false;
                System.out.println("Number format mismatch.");
            }
            catch (Exception e) {
                valid = false;
                System.out.println(e);
            }

        } while (valid == false);
        return num;
    }

}
