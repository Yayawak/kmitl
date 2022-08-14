package JavaLearner.projects;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
    public MyFrame(){
        super("Very basic frame");
        setSize(500,300);

        JLabel welcome = new JLabel("Welcome to primer app");
        welcome.setBounds(200,100,150,200);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(welcome);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    } 
}
