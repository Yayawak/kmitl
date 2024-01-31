package Lab2LineAlgorithms;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;




public class MainFrame extends JFrame {
    public MainFrame()
    {
        System.out.println("Making MainFrame");
        var pn = new MyPanel();
        add(pn);
        setVisible(true);
    }

}
