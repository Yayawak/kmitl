package Assignment_1_Newyear.View;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import Assignment_1_Newyear.View.Center.Center;
import Assignment_1_Newyear.View.Console.Console;
import Assignment_1_Newyear.View.Side.Sidebar;
import Assignment_1_Newyear.View.Top.Topbar;

public class MainFrame extends JFrame {
    private static MainFrame ins;
    public static MainFrame getInstance() { if (ins == null) {ins = new MainFrame();} return ins;}
    public static int screenWidth = 900;
    public static int screenHeight = 600;

    private MainFrame()
    {
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        // setTitle("Happy New Year, Goodbye. 🐈");
        setTitle("Happy New Year, Goodbye.");

        setUIByAbsolute();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void setUIByGrid()
    {
        // setLayout(new GridBagLayout());
        // GridBagConstraints c = new GridBagConstraints();

        // c.weightx = 1;
        // c.weighty = 1;
        // // c.gridwidth = 2;
        // // c.gridheight = 2;
        // // c.gridwidth = 2;
        // c.fill = GridBagConstraints.BOTH;

        // c.gridx = 0;
        // c.gridy = 0;
        // c.weighty = 0.1;
        // c.weightx = 1;
        // c.gridwidth = 2;
        // add(Topbar.getInstance(), c);

        // c.gridx = 0;
        // c.gridy = 1;
        // c.weighty = 0.9;
        // c.weightx = 0.1;
        // c.gridwidth = 1;
        // add(Sidebar.getInstance(), c);

        // c.gridx = 1;
        // c.gridy = 1;
        // c.weighty = 0.9;
        // c.weightx = 0.9;
        // // c.gridwidth = 9;
        // add(Center.getInstance(), c);

    }

    void setUIByAbsolute()
    {
        setLayout(null);
        Topbar.getInstance().setBounds(
            new Rectangle(
                0, 
                0, 
                screenWidth,
                (int)(screenHeight * 0.1)
            )
        );        
        Sidebar.getInstance().setBounds(
            new Rectangle(
                0, 
                (int)(screenHeight * 0.1),
                (int)(screenWidth * 0.2),
                (int)(screenHeight * 0.6)
            )
        );        
        Console.getInstance().setBounds(
            new Rectangle(
                0, 
                // 100,
                (int)(screenHeight * (0.1 + 0.6)),
                (int)(screenWidth * 0.2),
                (int)(screenHeight * 0.4)
            )
        );        
        Center.getInstance().setBounds(
            new Rectangle(
                (int)(screenWidth * 0.2),
                (int)(screenHeight * 0.1),
                (int)(screenWidth * 0.9),
                (int)(screenHeight * 0.9)
            )
        );        

        add(Topbar.getInstance());
        add(Sidebar.getInstance());
        add(Center.getInstance());
        add(Console.getInstance());
    }
}
