package Assignment_1_Newyear.View.Top;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Assignment_1_Newyear.Controller.ImageApi;
import Assignment_1_Newyear.View.Components.CustomImage.CustomImagePanel;
import Assignment_1_Newyear.View.Components.CustomImage.PencilTool;

public class Topbar extends JPanel {
    private static Topbar ins;
    public static Topbar getInstance() { if (ins == null) {ins = new Topbar();} return ins;}


    private Topbar()
    {
        System.out.println("Setting up Topper");
        setBackground(Color.blue);
        // add(new JLabel("Topbar"));

        // var pencilPanel = new JPanel();
        // pencilLabel.setIcon(pencilIcon);
        // add(pencilLabel);
        // CustomImagePanel pencilPanel = new PencilTool(
        //     "Assignment_1_Newyear/Assets/Icons/pencil.png"
        // );
        add(PencilTool.getInstance());
    }


}
