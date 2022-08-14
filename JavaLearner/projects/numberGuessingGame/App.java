package JavaLearner.projects.numberGuessingGame;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random() * 100 + 1);        
        int userAnsNumber = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int counter = 1;
        while (computerNumber != userAnsNumber ) {
            String msg = "Enter number between 1-100, \"Guess game\"";
            JOptionPane.showMessageDialog(null, "Computer number is " + computerNumber);
            String response = JOptionPane.showInputDialog(null, msg, 3);
            userAnsNumber = Integer.parseInt(response);
            // System.out.println("Your guess is " + userAnsNumber);
            String outputMsg = guessGuild(userAnsNumber, computerNumber, counter);
            JOptionPane.showMessageDialog(null, outputMsg);
            counter++;
        }
    }

    public static String guessGuild(int yourAns, int computerNum, int counter) {
        String tryNTimes = "\nTry " + counter + " times";
        if (yourAns == computerNum) {
            return "Correct guessing !!!";
        }else if (yourAns > computerNum ) {
            return "Your guess is too high" + tryNTimes;
        }
        else if (yourAns < computerNum ) {
            return "Your guess is too low" + tryNTimes;
        }
        else if (yourAns != computerNum) {
            return "Incorect guessing!" + tryNTimes;
        }
        else {
            return "error anw";
        }
    }
}