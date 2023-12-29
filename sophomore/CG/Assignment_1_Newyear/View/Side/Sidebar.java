package Assignment_1_Newyear.View.Side;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Assignment_1_Newyear.Controller.ImageApi;
import Assignment_1_Newyear.Model.PrimaryShape;
import Assignment_1_Newyear.View.MainFrame;
import Assignment_1_Newyear.View.Components.Tools.CustomImagePanel;
import Assignment_1_Newyear.View.Components.Tools.PencilTool;

public class Sidebar extends JScrollPane {
    private static Sidebar ins;
    public static Sidebar getInstance() { if (ins == null) {ins = new Sidebar();} return ins;}
    private int totalRows = 0;

    public JPanel mainPanel = new JPanel();


    private Sidebar()
    {
        setBackground(Color.decode("#3FC1C9"));
        // add(new JLabel("Topbar"));
        Dimension size = new Dimension(
                (int)(MainFrame.screenWidth * 0.2f),
                (int)(MainFrame.screenHeight * 0.8f)
            );

        // setMaximumSize(size);
        // setMinimumSize(size);
        // setPreferredSize(size);

        add(mainPanel);
        var boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(boxLayout);


        setViewportView(mainPanel);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    // public void addCustomerToScrollRow(CustomerModel customer)
    public void addRow(PrimaryShape shape)
    {
        // var wrapperRow = new WrapperCustomerRow(customer);
        var wrapperRow = new RowWrapper(shape, totalRows);
        // shape.toString()
        mainPanel.add(wrapperRow);
        totalRows++;
        repaint();
        revalidate();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void clearAll()
    {
        mainPanel.removeAll();
    }


}
