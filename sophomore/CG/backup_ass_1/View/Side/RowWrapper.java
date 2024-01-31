package backup_ass_1.View.Side;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Assignment_1_Newyear.Model.PrimaryShape;
import Assignment_1_Newyear.View.MainFrame;

public class RowWrapper extends JPanel {

    int index;
    JLabel label = new JLabel();
    Color color;

    public RowWrapper(PrimaryShape shape, int index)
    {
        label.setText(shape.toString());
        this.index = index;
        // color = shape.color;
        Color a = Color.decode("#1BE6CC");
        Color b = Color.decode("#009B9D");
        // color = index % 2 == 0 ? Color.red : Color.gray;
        color = index % 2 == 0 ? a : b;
        setBackground(color);
        // Dimension size = new Dimension(
        //         // 100, 25
        //     (int)(MainFrame.screenWidth * 0.2),
        //     25
        // );
        // setPreferredSize(size);
        // setMaximumSize(size);
        // setMinimumSize(size);
        // setSize(size);
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
    }

}
