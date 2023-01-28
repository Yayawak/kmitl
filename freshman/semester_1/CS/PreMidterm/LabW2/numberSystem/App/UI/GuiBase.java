package CS.LabW2.numberSystem.App.UI;

import javax.swing.*;

public class GuiBase extends JFrame {
    private JPanel jContentPane = null;
    public GuiBase(){
        super();
        initialize();
    }
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);

            // ? ============== PANEL =================

            JPanel basePanel = new JPanel();
            basePanel.setBounds(60, 10, 90, 140);
            basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
            jContentPane.add(basePanel);

            JPanel decimalPanel = new JPanel();
            JPanel convertedNumPanel = new JPanel();


            // ? ============= COMPONENTS ==================
            JButton convertBtn = new JButton("Convert");
            JLabel decimal_number_lb = new JLabel("Decimal");
            JTextArea decimal_ta = new JTextArea("decimal number");

            JLabel converted_number_lb = new JLabel("Converted base");
            JTextArea converted_number_ta = new JTextArea("..........");

            // ? ================= ADDING TO PANELS ================

            decimalPanel.add(decimal_number_lb);
            decimalPanel.add(decimal_ta);

            convertedNumPanel.add(converted_number_lb);
            convertedNumPanel.add(converted_number_ta);

            basePanel.add(decimalPanel);
            basePanel.add(convertedNumPanel);
            basePanel.add(convertBtn);

            // frame.add(basePanel);
            // add(basePanel);

            // jContentPane.add(basePanel);
            // pack();

        }
        return jContentPane;
    }
    private void initialize(){
        // this.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Decimal to any base (Except hextal)");
        this.setContentPane(getJContentPane());
        // this.setVisible(true);
    }
}
