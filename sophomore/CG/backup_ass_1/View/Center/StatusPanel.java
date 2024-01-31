package backup_ass_1.View.Center;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StatusPanel extends JPanel
{
    private static StatusPanel ins;
    public static StatusPanel getInstance() { if (ins == null) {ins = new StatusPanel();} return ins;}

    private JLabel label = new JLabel();

    public StatusPanel()
    {
        setBackground(Color.decode("#FC5085"));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setString("default status");
        add(label);
    }

    public void setString(String s)
    {
        // System.out.println("set string : " + s);
        label.setText(s);
        // label.revalidate();
        revalidate();
    }
}
