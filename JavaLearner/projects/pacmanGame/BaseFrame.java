package JavaLearner.projects.pacmanGame;

import javax.swing.JFrame;

import JavaLearner.projects.pacmanGame.Board.Board;

// import java.awt.EventQueue;

public class BaseFrame extends JFrame {
    public BaseFrame (){
        initUI();
    }
    private void initUI() {
        add(new Board());
    }
}
