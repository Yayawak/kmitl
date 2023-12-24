// package NewYear;

// import java.awt.Button;
// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Point;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// import javax.swing.JPanel;

// // import Lab2LineAlgorithms.Drawer;
// import Lab2LineAlgorithms.Drawing;
// import Lab2LineAlgorithms.LineAlgorithms;
// import Lab3CurveTrigFloodFill.BazierAlgorithm;
// import NewYear.Dragon.Old.DragonGraphic;

// public class SwingPanel extends JPanel {
//     // Drawer drawer = new Drawer();
//     DragonGraphic dragon;
//     Button button = new Button("Universal Button");
//     // int x = 0;
//     Point headPoint;

//     public SwingPanel()
//     {
//         headPoint = new Point(200, 300);
//         setBackground(Color.gray);
//         add(button);
//         button.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 System.out.println("clicked button");
//                 repaint();
//                 // x++;
//             }
//         });
//     }



//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);

//         int offsetX = 5;
//         headPoint = new Point(headPoint.x + offsetX, headPoint.y);
//         // drawer.setGraphicInit(g);
//         // ! most important line
//         Drawing.attachGraphics(g);

//         // * i know this is bad but i too lazy to fix it
//         dragon = new DragonGraphic();
//         // drawer.g = g;
//         // g.setColor(Color.orange);
//         // BazierAlgorithm.bezier(100, 100, 200, 200, 300, 100, 400, 600, 4);

//         LineAlgorithms.drawGrid(
//             getWidth(), getHeight(), 
//             20, 15
//         );

//         // dragon
//         // g.translate(3, 0);
//         // drawer.bshLine(100, 100, 400, 500);
//     }
// }
