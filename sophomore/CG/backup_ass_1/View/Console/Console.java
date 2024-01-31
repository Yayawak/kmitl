package backup_ass_1.View.Console;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Assignment_1_Newyear.Controller.ImageApi;
import Assignment_1_Newyear.Model.PrimaryShape;
import Assignment_1_Newyear.View.MainFrame;
import Assignment_1_Newyear.View.Components.Tools.CustomImagePanel;
import Assignment_1_Newyear.View.Components.Tools.PencilTool;

public class Console extends JScrollPane {
// public class Console extends JPanel {
    private static Console ins;
    public static Console getInstance() { if (ins == null) {ins = new Console();} return ins;}
    // private int totalRows = 0;
    JPanel mainPanel = new JPanel();
    JTextArea textArea;

    private Console()
    {
        textArea = new JTextArea(100, 20);
        // textArea.setBackground(Color.decode("#9B6BDF"));
        // textArea.setBackground(Color.decode("#FB5086"));
        textArea.setBackground(Color.decode("#364F6B"));
        Dimension size = new Dimension(
                (int)(MainFrame.screenWidth * 0.2f),
                (int)(MainFrame.screenHeight * 0.2f)
        );
        // setMaximumSize(size);
        // setMinimumSize(size);
        // setPreferredSize(size);

        textArea.setLineWrap(true);
        textArea.setEditable(false);
        // textArea.setFont(new Font("Serif", Font.ITALIC, 10));
        // textArea.setWrapStyleWord(true);

        // setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // areaScrollPane.setPreferredSize(new Dimension(250, 250));

        add(mainPanel);
        // mainPanel.setLayout(new BorderLayout());
        setViewportView(mainPanel);
        // setViewportView(textArea);

        // add(textArea);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        // add(textArea);
    }

    public void addRowString(String s)
    {
        // totalRows++;
        textArea.append(s + "\n");
        // textArea.append("Hello");
        // textArea.revalidate();
        revalidate();
        // textArea.repaint();
    }
}
