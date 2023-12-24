package Assignment_1_Newyear.View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import Assignment_1_Newyear.View.Center.Center;
import Assignment_1_Newyear.View.Top.Topbar;

public class MainFrame extends JFrame {
    private static MainFrame ins;
    public static MainFrame getInstance() { if (ins == null) {ins = new MainFrame();} return ins;}
    public static int screenWidth = 700;
    public static int screenHeight = 500;

    private MainFrame()
    {
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());


        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.1;
        add(Topbar.getInstance(), c);

        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.9;
        add(Center.getInstance(), c);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
