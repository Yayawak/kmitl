package PF.PreMidterm.LabW5.Lab2;

public class Lab2Q1_65988_palindrome {
    public static void main(String[] args) {
        String initString = "ada";
        // String initString = args[0];
        String revertedString = "";

        int length = initString.length();

        for (int i=length-1; i>-1; i--) {
            revertedString += initString.charAt(i);
            System.out.println(initString.charAt(i));
        }

        System.out.println("Initial string : " + initString);
        System.out.println("Reverted string : " + revertedString);
        // if (initString.compareTo(revertedString)) {
        if (initString.equals(revertedString)) {
            System.out.println(initString + " is Palindrome !");
        }else {
            System.out.println(initString + " is NOT Palindrome !");
        }
        // System.out.println("Reverted string is : " + revertedString);
    }
}
