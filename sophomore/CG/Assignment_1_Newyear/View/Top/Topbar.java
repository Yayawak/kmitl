package Assignment_1_Newyear.View.Top;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.security.auth.RefreshFailedException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Assignment_1_Newyear.View.Components.Tools.ColorSelectorTool;
import Assignment_1_Newyear.View.Components.Tools.BucketTool;
import Assignment_1_Newyear.View.Components.Tools.LineWidthTool;
import Assignment_1_Newyear.View.Components.Tools.PenTool;
import Assignment_1_Newyear.View.Components.Tools.PencilTool;
import Assignment_1_Newyear.View.Components.Tools.PrevTool;
import Assignment_1_Newyear.View.Components.Tools.RefreshTool;
import Assignment_1_Newyear.View.Components.Tools.SnapTool;
import Lab3CurveTrigFloodFill.FloodFill;

// public class Topbar extends JPanel {
public class Topbar extends JPanel {
    private static Topbar ins;
    public static Topbar getInstance() { if (ins == null) {ins = new Topbar();} return ins;}


    private Topbar()
    {
        System.out.println("Setting up Topper");
        setBackground(Color.decode("#364F6B"));
        // add(new JLabel("Topbar"));

        // var pencilPanel = new JPanel();
        // pencilLabel.setIcon(pencilIcon);
        // add(pencilLabel);
        // CustomImagePanel pencilPanel = new PencilTool(
        //     "Assignment_1_Newyear/Assets/Icons/pencil.png"
        // );
        add(PencilTool.getInstance());
        add(ColorSelectorTool.getInstance());
        add(PenTool.getInstance());
        add(BucketTool.getInstance());
        add(LineWidthTool.getInstance());
        // add(SnapTool.getInstance()); // ! still developing
        add(PrevTool.getInstance());
        add(RefreshTool.getInstance());
    }


}
