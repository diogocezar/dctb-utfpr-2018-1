package game.gui;

import game.control.Creature;
import game.control.Hero;
import game.control.Monster;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class CreaturePanel extends JFrame implements ActionListener {

    private ArrayList<Creature> creatures;
    private JLabel label[] = new JLabel[11];
    private JLabel imageCreature;
    private JPanel panelInfo;
    private JPanel panelArrow;
    private JButton buttonLeft;
    private JButton buttonRight;
    private JButton selectPlayer;
    private Creature playerCreature;
    private Creature creatureTypeTemp;
    private BufferedImage image = null;
    private int valueCreature = 0;
    private int valueCreatureTemp;
    private boolean isActive = true;


    public CreaturePanel(String text, ArrayList<Creature> creatures) {
        super(text);
        BufferedImage imageBG = null;
        try {
            imageBG = ImageIO.read(getClass().getClassLoader().getResource("game/res/section_2_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setContentPane(new JLabel(new ImageIcon(Game.createResizedCopy(imageBG, 500, 300, true))));
        this.creatures = creatures;
        setMinimumSize(new Dimension(500, 300));
        setMaximumSize(new Dimension(500, 300));
        setPreferredSize(new Dimension(500, 300));
        revalidate();
        setLayout(new BorderLayout());
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void printCreatures() {

        panelArrow = new JPanel(new GridLayout(1, 2));
        buttonLeft = new JButton("Anterior");
        buttonRight = new JButton("Proximo");
        this.add(panelArrow, BorderLayout.SOUTH);
        panelArrow.add(buttonLeft);
        panelArrow.add(buttonRight);
        buttonLeft.addActionListener(this);
        buttonRight.addActionListener(this);
        create();
        init();
    }

    public void init() {
        update(creatures.get(valueCreature));
    }

    public void create() {

        panelInfo = new JPanel();
        this.add(panelInfo, BorderLayout.CENTER);
        panelInfo.setLayout(new GridLayout(5, 2));
        panelInfo.setOpaque(true);


        imageCreature = new JLabel();
        add(imageCreature, BorderLayout.WEST);

        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel();
            label[i].setOpaque(true);
            panelInfo.add(label[i]);
        }

        for (int i = 1; i < label.length; i++) {
            label[i].setBorder(new EmptyBorder(0, 35, 0, 0));
            label[i].setBorder(new LineBorder(new Color(0xE0E2D5), 1, false));
            label[i].setBackground(Color.white);
            label[i].setFont(label[i].getFont().deriveFont(Font.PLAIN));
        }

        this.add(label[0], BorderLayout.NORTH);

    }

    public void update(Creature creatureType) {
        creatureTypeTemp = creatureType;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResource("game/res/classCreatures/" + creatureType.image()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageCreature.setIcon(new ImageIcon(image));
        label[0].setText(creatureType.getName());
        label[0].setBackground(Color.black);
        label[0].setForeground(Color.white);
        label[0].setHorizontalAlignment(JLabel.CENTER);
        label[0].setVerticalAlignment(JLabel.CENTER);
        label[1].setText("<html><div style=\"padding-left: 40px\">Classe: <b>" + creatureType.getNameClass().name().toString() + "</b></div></html>");
        label[2].setText("<html><div style=\"padding-left: 40px\">Nível: <b>" + creatureType.getLevel()+ "</b></div></html>");
        label[3].setText("<html><div style=\"padding-left: 40px\">Vida: <b>" + creatureType.getLife()+ "</b></div></html>");
        label[4].setText("<html><div style=\"padding-left: 40px\">Magia: <b>" + creatureType.getMagic()+ "</b></div></html>");
        label[5].setText("<html><div style=\"padding-left: 40px\">Força: <b>" + creatureType.getStrength()+ "</b></div></html>");
        label[6].setText("<html><div style=\"padding-left: 40px\">Agilidade: <b>" + creatureType.getAgility()+ "</b></div></html>");
        label[7].setText("<html><div style=\"padding-left: 40px\">Destreza: <b>" + creatureType.getDexterity()+ "</b></div></html>");
        label[8].setText("<html><div style=\"padding-left: 40px\">Inteligencia: <b>" + creatureType.getIntelligence()+ "</b></div></html>");
        label[9].setText("<html><div style=\"padding-left: 40px\">Carisma: <b>" + creatureType.getCharism()+ "</b></div></html>");
        if (creatureType.getClass().equals(Hero.class)) {
            Hero hero = (Hero) creatureType;
            label[10].setText("<html><div style=\"padding-left: 40px\">Benção: <b>" + hero.getBoon()+ "</b></div></html>");
        } else {
            label[10].setText("<html><div style=\"padding-left: 40px\">Benção: <b>Não Possui</b></div></html>");
        }
    }

    public void buttonSelect(){
        selectPlayer = new JButton("Selecionar");
        panelArrow.add(selectPlayer, 1);
        selectPlayer.addActionListener(this);
    }

    public Creature getPlayerCreature() {
        return playerCreature;
    }

    public void player(){
        int reply = JOptionPane.showConfirmDialog(null, "Deseja selecionar um personagem", "JavaRPG", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            buttonSelect();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLeft) {
            valueCreature = valueCreature > 0 ? --valueCreature : creatures.size() - 1;
        }
        if (e.getSource() == buttonRight) {
            valueCreature = valueCreature >= creatures.size() - 1 ? 0 : ++valueCreature;
        }
        if (e.getSource() == selectPlayer) {
            playerCreature = creatureTypeTemp;
            setVisible(false);
            dispose();
        }
        init();
    }
}
