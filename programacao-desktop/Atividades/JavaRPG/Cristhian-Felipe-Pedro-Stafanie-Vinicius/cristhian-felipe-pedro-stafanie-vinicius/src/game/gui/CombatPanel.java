package game.gui;

import game.control.Combat;
import game.control.Creature;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static javax.swing.JOptionPane.showMessageDialog;

public class CombatPanel extends JFrame implements ActionListener {
    private Combat combat;
    private ArrayList<Creature> creatures;
    private int creatureNumber = 0;
    private boolean dubugActive = false;
    private Console output;
    private JLabel name[] = new JLabel[2];
    private JLabel life[] = new JLabel[2];
    private JLabel imageCreature[] = new JLabel[2];
    private JPanel playerPanel[] = new JPanel[2];
    private JButton buttonChar[] = new JButton[2];
    private JButton buttonNext[] = new JButton[2];;

    public CombatPanel(String text, Combat combat){
        super(text);
        this.combat = combat;
        creatures = combat.getCreatures();
        setMinimumSize(Game.DIMENSIONS);
        setMaximumSize(Game.DIMENSIONS);
        setPreferredSize(Game.DIMENSIONS);
        revalidate();
        setLayout(new BorderLayout());
        output = new Console();
        output.setVisible(dubugActive);
        add(output, BorderLayout.NORTH);
        init();
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init(){
        getContentPane().setBackground(new Color(0x1B1B1B));
        JPanel playerBattle = new JPanel(new GridLayout(1,2));
        playerBattle.setOpaque(false);
        add(playerBattle, BorderLayout.CENTER);
        JPanel panelButtons = new JPanel(new FlowLayout());
        add(panelButtons, BorderLayout.SOUTH);
        panelButtons.setOpaque(false);
        for (int i = 0; i < buttonNext.length; i++) {
            buttonNext[i] = new JButton();
            buttonNext[i].setForeground(Color.WHITE);
            buttonNext[i].setVerticalTextPosition(SwingConstants.CENTER);
            buttonNext[i].setHorizontalTextPosition(SwingConstants.CENTER);
            buttonNext[i].setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            buttonNext[i].setMargin(new Insets(2, 0, 2, 0));
            buttonNext[i].setPreferredSize(new Dimension(230,75));
            buttonNext[i].setContentAreaFilled(false);
            buttonNext[i].setFocusPainted(false);
            buttonNext[i].setOpaque(false);
            buttonNext[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            BufferedImage imageButton = null;
            try {
                imageButton = ImageIO.read(getClass().getClassLoader().getResource("game/res/link_character.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            buttonNext[i].setIcon(new ImageIcon(imageButton));
            panelButtons.add(buttonNext[i]);
            buttonNext[i].addActionListener(this);
        }
        buttonNext[0].setText(" >> ");
        buttonNext[1].setText(" Debug ");

        for (int i = 0; i < playerPanel.length; i++) {
            playerPanel[i] = new JPanel();
            playerPanel[i].setOpaque(false);
            playerBattle.add(playerPanel[i], 0, i);
            playerPanel[i].setLayout(new BoxLayout(playerPanel[i],BoxLayout.Y_AXIS));
            imageCreature[i] = new JLabel();
            playerPanel[i].add(imageCreature[i]);
            playerPanel[i].setBorder(new EmptyBorder(Game.DIMENSIONS.height/12, Game.DIMENSIONS.width/6, 5, 0));
            imageCreature[i].setBorder(BorderFactory.createMatteBorder(8, 2, 8, 2, new Color(0x6A1920)));
            name[i] = new JLabel("<html><div style=\"padding-left: 15px\">" + creatures.get(i).getName() + "</div></html>");
            name[i].setOpaque(true);
            name[i].setBackground(Color.black);
            name[i].setForeground(Color.white);
            name[i].setBorder(new EmptyBorder(10,0,10,0));
            playerPanel[i].add(name[i]);
            life[i] = new JLabel("<html><div style=\"padding-left: 15px\">" + creatures.get(i).getLife() + "</div></html>");
            life[i].setOpaque(true);
            life[i].setBackground(new Color(0x4DDD1B));
            life[i].setForeground(Color.white);
            life[i].setBorder(new EmptyBorder(10,0,10,0));
            playerPanel[i].add(life[i]);
            BufferedImage image = null;
            try {
                image = ImageIO.read(getClass().getClassLoader().getResource("game/res/classCreatures/" + creatures.get(i).image()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageCreature[i].setIcon(new ImageIcon(image));
            buttonChar[i] = new JButton();
            BufferedImage imageButtonChar = null;
            try {
                imageButtonChar = ImageIO.read(getClass().getClassLoader().getResource("game/res/link_character_sm.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            buttonChar[i].setIcon(new ImageIcon(imageButtonChar));
            buttonChar[i].setBorder(BorderFactory.createEmptyBorder(7, 0, 7, 0));
            buttonChar[i].setText("Ver");
            buttonChar[i].setFont(new Font("SansSerif", Font.PLAIN, 12));
            buttonChar[i].setForeground(new Color(0xDADFDC));
            buttonChar[i].setVerticalAlignment(SwingConstants.CENTER);
            buttonChar[i].setVerticalTextPosition(SwingConstants.CENTER);
            buttonChar[i].setHorizontalAlignment(SwingConstants.CENTER);
            buttonChar[i].setHorizontalTextPosition(SwingConstants.CENTER);
            buttonChar[i].setContentAreaFilled(false);
            buttonChar[i].setFocusPainted(false);
            buttonChar[i].setOpaque(false);
            buttonChar[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttonChar[i].addActionListener(this);
            playerPanel[i].add(buttonChar[i]);
        }
    }

    public void update(){
        for (int i = 0; i < playerPanel.length; i++) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(getClass().getClassLoader().getResource("game/res/classCreatures/" + creatures.get(i+creatureNumber).image()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageCreature[i].setIcon(new ImageIcon(image));
            name[i].setText("<html><div style=\"padding-left: 15px\">" + creatures.get(i+creatureNumber).getName() + "</div></html>");
            life[i].setText("" + creatures.get(i+creatureNumber).getLife());
            life[i].setBorder(new EmptyBorder(10,creatures.get(i+creatureNumber).getLife() * 3,10,0));
            if(creatures.get(i+creatureNumber).getLife()<30)
                life[i].setBackground(new Color(0xDD101C));
            else if (creatures.get(i+creatureNumber).getLife()<60)
                life[i].setBackground(new Color(0xDDDC2B));
            else
                life[i].setBackground(new Color(0x4DDD1B));
        }
    }

    public void message(){
        if (Objects.isNull(combat.getPlayer()))
            showMessageDialog(null, creatures.get(0).getName()+" venceu o jogo");
        else{
            if (Objects.equals(combat.getPlayer(), creatures.get(0)))
                showMessageDialog(null, "Parabéns seu personagem "+creatures.get(0).getName()+" venceu o jogo");
            else
                showMessageDialog(null, creatures.get(0).getName()+ " venceu o jogo \n Seu personagem "+combat.getPlayer().getName()+"foi derrotado");
        }
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getSource() == buttonNext[0]) {
                    combat.init();
                    creatureNumber = combat.getCountGame();
                    if (combat.isWinner())
                        message();
                    else
                        update();
            }
            if (e.getSource() == buttonNext[1]){
                dubugActive = dubugActive?false:true;
                output.setVisible(dubugActive);
            }
            if (e.getSource() == buttonChar[0]){
                CreaturePanel creaturePanel = new CreaturePanel("Ver Criatura - JavaRPG", creatures);
                creaturePanel.create();
                creaturePanel.update(creatures.get(creatureNumber));
            }
            if (e.getSource() == buttonChar[1]){
                CreaturePanel creaturePanel = new CreaturePanel("Ver Criatura - JavaRPG", creatures);
                creaturePanel.create();
                creaturePanel.update(creatures.get(creatureNumber+1));
            }
        }
    }
}
