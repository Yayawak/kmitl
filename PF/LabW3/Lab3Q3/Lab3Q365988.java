package PF.LabW3.Lab3Q3;

public class Lab3Q365988 {
    public static void main(String[] args) {
        // * 1St Way
        System.out.println(sumV1());
    } 
    public static int sumV1 () {
        int currentNumber = 0;
        int sum = 0;
        int counter = 0;
        
        while(currentNumber < 1000 ) {
            if (currentNumber % 3 == 0 || currentNumber % 5 == 0 ) {
                sum += currentNumber;
                counter++;
                // System.out.println(currentNumber);
            }
            currentNumber++; 
        }
        System.out.println(counter);
        return sum;

    }
}
