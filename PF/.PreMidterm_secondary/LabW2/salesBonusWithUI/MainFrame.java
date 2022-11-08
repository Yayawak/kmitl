package PF.PreMidterm.LabW2.SalesBonusWithUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();
        initUI();
    }
    private void initUI() {
        Container container = getContentPane();
        setBounds(0,0,600,300);

        // SALES
        JLabel sales_lb = new JLabel("Enter Sales Amount");
        JTextField sales_tf = new JTextField();
        sales_tf.setSize(200,50);

        container.add(sales_lb);
        container.add(sales_tf);

        // * : IS TEAM
        JCheckBox isTeam_cb = new JCheckBox("Is Team");

        container.add(isTeam_cb);

        JOptionPane op = new JOptionPane();
        container.add(op);

        // * : setting before end
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
