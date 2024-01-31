package Lab2LineAlgorithms;
/**
 *
 * @author avondale
 */
import javax.swing.*;
public class Main {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        // mf.setLocationRelativeTo(null);
        // mf.setBounds(0, 0, 720, 480);
        mf.setSize(
            // 1920, 1280
            // 1000, 700
            720, 480
        );
        mf.setTitle("First Swing Application");
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setLocationRelativeTo(null);
        // mf.setVisible(true);
    }
}
