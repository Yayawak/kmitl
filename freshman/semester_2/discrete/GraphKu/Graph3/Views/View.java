package Graph3.Views;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import Graph3.Controllers.Controller;
import Graph3.Models.Graph;
import Graph3.Models.Hero;
import Graph3.Models.Model;

public class View extends JFrame {
    Graph<Hero> graph = Controller.getInstance().getGraph();
    // private Hero[] heroes = Controller.getInstance().getHeroes();
    private Hero[] heroes = Model.getHeroes();

    public View() {
        initUI();
        showGraph();
    }

    void initUI() {
        setLayout(null);
        setSize(1400, 700);
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // private Point randomPosition(int[] limitX, int[] limitY) {

    // }

    private void showGraph() {
        Arrays.asList(heroes).stream()
            .forEach(h -> {
                Point pos = new Point(
                    (int)(Math.random() * 1200),
                    (int)(Math.random() * 600)
                );

                // if created heroview(Jpanel ) is overlap
                // todo : re random posion (with offset)
                createHeroView(h, pos);
            });
    }

    private void organizeGraphPositioning() {

    }

    private void createHeroView(Hero hero, Point pos) {
        HeroView hv = new HeroView(hero, pos);
        add(hv);
    }
}
