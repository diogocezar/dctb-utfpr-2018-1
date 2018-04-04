package game.gui;

import game.control.Combat;
import game.control.Creature;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

public class Control implements ActionListener, MouseListener {

    private ArrayList<Creature> creatures;
    private ArrayList<JButton> menuButtons;
    private CreaturePanel creaturePanel;
    private CombatPanel combatPanel;
    private Combat combat;
    private Game game;

    public Control(ArrayList<Creature> creatures, Game game, Combat combat) {
        super();
        this.creatures = creatures;
        this.menuButtons = game.getMenuButtons();
        this.game = game;
        this.combat = combat;
        addActionListeners();
    }

    public void addActionListeners() {
        for (int i = 0; i < menuButtons.size(); i++) {
            menuButtons.get(i).addActionListener(this);
            menuButtons.get(i).addMouseListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getSource() ==  menuButtons.get(0)){
                if (!Objects.isNull(creaturePanel) && !Objects.isNull(creaturePanel.getPlayerCreature()))
                    combat.setPlayer(creaturePanel.getPlayerCreature());
                printRounds();
                CombatPanel combatPanel = new CombatPanel("Combate - JavaRPG",combat);
                game.setVisible(false);
            }
            if (e.getSource() ==  menuButtons.get(1)){
                creaturePanel = new CreaturePanel("Visualizar Criaturas - JavaRPG",creatures);
                creaturePanel.printCreatures();
                creaturePanel.player();
            }
            if (e.getSource() ==  menuButtons.get(2))
               System.exit(0);
        }
    }

    public void printRounds(){
        String[] opcoes = {"10","25","50", "100"};
        String resp = (String) JOptionPane.showInputDialog(null,
                "Selecione o numero maximo de rodadas", "ROUNDS",
                JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
        combat.setMaxRounds(Integer.parseInt(resp));
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
