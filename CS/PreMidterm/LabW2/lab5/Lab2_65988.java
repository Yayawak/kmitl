package CS.LabW2.lab5;

public class Lab2_65988 {
    public static void main(String[] args) {
        int x = 5, y = 4, temp;

        System.out.println("Before Swapping");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        
        // * : Swap
        temp = x; //temp = 5
        x = y; // x pointed to y; x = 4;
        y = temp; // y = temp = 5;


        System.out.println("After Swapping");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
