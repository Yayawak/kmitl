package Lab5_DeltaTime_Animation;

import javax.swing.JFrame;

public class AnimDriver {

    public static void main(String[] args) {
        JFrame f = new JFrame();     
        var m = new AnimPanel();
        f.add(m);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

        (new Thread(m)).start();

    }
}
