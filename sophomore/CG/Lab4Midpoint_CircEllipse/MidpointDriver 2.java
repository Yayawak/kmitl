package Lab4Midpoint_CircEllipse;

import javax.swing.JFrame;

public class MidpointDriver {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(700, 500);
        f.setLocationRelativeTo(null);
        f.add(new MidpointTestPanel());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
