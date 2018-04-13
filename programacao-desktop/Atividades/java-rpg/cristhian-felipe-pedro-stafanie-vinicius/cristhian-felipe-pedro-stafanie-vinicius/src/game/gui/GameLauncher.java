package game.gui;

import game.control.Combat;
import game.control.Creature;
import game.control.Hero;
import game.control.Monster;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameLauncher {

    private static Game game = new Game();
    private ArrayList<Creature> creatures = new ArrayList();
    private Control control;
    private Combat combat;


    public GameLauncher() {
        game.setMinimumSize(Game.DIMENSIONS);
        game.setMaximumSize(Game.DIMENSIONS);
        game.setPreferredSize(Game.DIMENSIONS);
        game.revalidate();
        game.setLayout(null);
        game.init();
        game.pack();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setResizable(false);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        combat = new Combat();
        combat.create();
        creatures = combat.getCreatures();
        update();
    }

    public void update(){
        control = new Control(creatures, game, combat);
    }

    public static void main(String[] args) {
        GameLauncher gui = new GameLauncher();
    }
}
