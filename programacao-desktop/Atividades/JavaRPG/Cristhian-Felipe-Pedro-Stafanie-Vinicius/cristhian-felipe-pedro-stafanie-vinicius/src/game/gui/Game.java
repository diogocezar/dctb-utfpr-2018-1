package game.gui;

import javafx.beans.property.adapter.JavaBeanBooleanProperty;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Cursor;

public class Game extends JFrame{

    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 6;
    public static final String NAME = "JavaRPG";
    public static final Dimension DIMENSIONS = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
    private JPanel gamePanel;
    private JPanel menuPanel;
    private ArrayList<JButton> menuButtons = new ArrayList<JButton>(4);


    public Game(){
        super (NAME);

        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResource("game/res/sec4_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setContentPane(new JLabel(new ImageIcon(createResizedCopy(image, DIMENSIONS.width, DIMENSIONS.height, true))));


        gamePanel = new JPanel();
        gamePanel.setBounds(DIMENSIONS.width/6, DIMENSIONS.height/3, DIMENSIONS.width, DIMENSIONS.height);
        BoxLayout bl = new BoxLayout(gamePanel, BoxLayout.Y_AXIS);
        gamePanel.setLayout(bl);
        gamePanel.setOpaque(false);
        this.add(gamePanel);
    }

    public void init(){
        initButtons();
    }

    public void initButtons(){
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResource("game/res/link_character.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i=0; i < 3;i++) {
            JButton create = new JButton();
            menuButtons.add(create);
        }

        for (JButton createMenuButton: menuButtons) {
            createMenuButton.setIcon(new ImageIcon(image));
            gamePanel.add(createMenuButton);
            createMenuButton.setHorizontalTextPosition(createMenuButton.CENTER);
            createMenuButton.setVerticalAlignment(createMenuButton.CENTER);
            createMenuButton.setForeground(Color.WHITE);
            createMenuButton.revalidate();
            createMenuButton.setContentAreaFilled(false);
            createMenuButton.setBorderPainted(false);
            createMenuButton.setBorder(null);
            createMenuButton.setOpaque(false);
            createMenuButton.repaint();
        }

        //Font font = new Font(Font.DIALOG, Font.BOLD, 14);
        menuButtons.get(0).setText("COMEÇAR DUELO");
        menuButtons.get(1).setText("VER CRIATURAS");
        menuButtons.get(2).setText("SAIR");
        //menuButtons.get(0).setFont(font);
        menuButtons.get(0).setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuButtons.get(1).setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuButtons.get(2).setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static BufferedImage createResizedCopy(Image originalImage,
                                    int scaledWidth, int scaledHeight,
                                    boolean preserveAlpha)
    {
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public ArrayList<JButton> getMenuButtons() {
        return menuButtons;
    }
}
