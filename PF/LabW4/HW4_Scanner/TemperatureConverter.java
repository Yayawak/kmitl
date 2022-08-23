package PF.LabW4.HW4_Scanner;
import java.util.Scanner;


public class TemperatureConverter {
    static Scanner sc = new Scanner(System.in);
    static float celsius;
    static String selectedUnit;
    static float inputDegree;
    static String degSymbol = "\u00B0";
    public static void main(String[] args) {

        System.out.println();
        System.out.println();
        System.out.println("Any Units to Celsius degree");
        String[] units = {"Farenheit", "Kelvin", "Reaumur"};
        System.out.println("Select : ");
        for(int i=0; i<units.length; i++) {
            System.out.printf("\t%d).  %s\n", i+1, units[i]);
        }
        int choice = (int)recieveNumber("Choice");

        // todo : error handler for out of bounds selectedUnit
        inputDegree = (float)recieveNumber(units[choice-1]);
        selectedUnit = units[choice-1];

        switch (choice) {
            case 1:
                celsius = (5.0f/9.0f)*(inputDegree-32);
                break;
            case 2:
                celsius = inputDegree - 273.15f;
                break;
            case 3:
                celsius = inputDegree * (5f/4);
                break;
            default:
                celsius = (5.0f/9.0f)*(inputDegree-32);
                System.out.println("Default choice is Farenheit degree.");
        }
        printDegree();

        sc.close();
    } 
    static void printDegree() {
        String leadLetter = selectedUnit.substring(0,1).toUpperCase();
        System.out.printf("%.2f%s%s => %.2f%sC\n", 
            inputDegree, degSymbol, leadLetter,
            celsius, degSymbol);
    }
    static float recieveNumber(String label) {
        String strNum;
        do {
            System.out.printf("Insert number (%s) : ", label);
            strNum = sc.nextLine();
            if (isNumeric(strNum)) {
                System.out.println();
                return Float.parseFloat(strNum);
            }else {
                System.out.println("Please insert number not character.");
                System.out.println();
            }
            
        } while(true);

    }
    static boolean isNumeric(String str) {
        try{
            Double.parseDouble(str);
            return true;
        }catch(NumberFormatException e){ return false;
        } 
    }
}
