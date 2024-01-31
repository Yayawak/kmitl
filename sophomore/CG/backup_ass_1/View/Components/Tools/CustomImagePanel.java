package backup_ass_1.View.Components.Tools;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Assignment_1_Newyear.Controller.ImageApi;

public abstract class CustomImagePanel extends JPanel {
    // JLabel pencilLabel = new JLabel();
    // ImageIcon pencilIcon;
    JLabel iconLabel = new JLabel();
    ImageIcon imageicon;

    public CustomImagePanel(String path)
    {
        imageicon = ImageApi.readImageIconFromFile( path, 40, 40);
        iconLabel.setIcon(imageicon);
        add(iconLabel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println("Clicked");
                onclick();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // System.out.println("Entered");
                onEnter();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                onExit();
            }
        });
    }

    protected abstract void onclick();
    protected void onEnter() {}
    protected void onExit() {}

}
