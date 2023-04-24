package Graph3.Views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

// import org.w3c.dom.events.MouseEvent;

import Graph3.Models.Hero;

public class HeroView extends JPanel
{
    private Hero hero;
    private GeneralPath path;
    private Color pathColor = Color.blue;
    private Stroke pathStroke = new BasicStroke();

    public HeroView(Hero hero, Point position) {
        this.hero = hero;
        setLocation(position);
        initUI();
        initEvents();
    }

    private GeneralPath getCircle(
        int radius
    ) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        GeneralPath path = new GeneralPath();
        path.moveTo(centerX + radius, centerY);
        for (int i = 1; i <= 360; i++) {
            double x = radius * Math.cos(Math.toRadians(i));
            double y = radius * Math.sin(Math.toRadians(i));
            path.lineTo(x + centerX, y + centerY);
        }
        path.closePath();
        return path;
    }

    private void initUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.blue);
        int squareSize = 100;
        setSize(
            squareSize, squareSize
        );
        Font font = new Font(Font.SANS_SERIF,
            Font.BOLD,
            15
        );
        JLabel nodeNameLabel = new JLabel(hero.getName());
        JLabel nodeDmgLabel = new JLabel(
            String.valueOf(hero.getAttackDamage()));
        nodeNameLabel.setFont(font);
        nodeDmgLabel.setFont(font);

        add(nodeNameLabel);
        add(nodeDmgLabel);

        pathColor = Color.green;
        pathStroke = new BasicStroke(10);
        path = getCircle(
            33
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(pathColor);
        g2d.setStroke(pathStroke);
        if (path != null)
            g2d.draw(path);
    }

    private void initEvents() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // pathColor = Color.green;
                // repaint();
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // repaint();
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                pathColor = Color.red;
                setLocation(e.getPoint());
                repaint();
            }
        });
    }


}




