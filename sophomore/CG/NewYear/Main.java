package NewYear;

import javax.swing.JFrame;

import Assignment_1_Newyear.Controller.ShapeReaderWriter;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("New Year Graphics Congratulation !");

        // f.setSize(1024, 720);
        f.setSize(700, 500);
        f.setLocationRelativeTo(null);
        f.add(new SwingPanel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
