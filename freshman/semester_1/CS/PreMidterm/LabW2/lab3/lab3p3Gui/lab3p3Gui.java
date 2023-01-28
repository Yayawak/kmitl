package CS.LabW2.lab3.lab3p3Gui;
import java.awt.*;

public class lab3p3Gui extends Frame {
    public static void main(String[] args) {
        int a = Integer.parseInt("5");
        int b = Integer.parseInt("10");
        // System.out.println(a + " " + b);

        int quotient = a / b;
        // System.out.println(quotient);

        int r = a - b*quotient;
        System.out.println("Remainder is : " + r);
    }
    lab3p3Gui() {
        Button btn = new Button("Click me");
        add(btn);
        setSize(500,500);
        setTitle("Remainder calucaltor");
        setLayout(null);
        setVisible(true);
    }
}
