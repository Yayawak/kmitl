package Assignment_1_Newyear.View.Center;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel
{
    private static StatusPanel ins;
    public static StatusPanel getInstance() { if (ins == null) {ins = new StatusPanel();} return ins;}

    private JLabel label = new JLabel();

    public StatusPanel()
    {
        setBackground(Color.ORANGE);
        setString("default status");
        add(label);
    }

    public void setString(String s)
    {
        System.out.println("set string : " + s);
        label.setText(s);
        // label.revalidate();
        revalidate();
    }
}
