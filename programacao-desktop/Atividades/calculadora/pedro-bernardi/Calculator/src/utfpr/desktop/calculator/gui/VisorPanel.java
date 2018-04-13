package utfpr.desktop.calculator.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Classe panel do visor da calculadora
 */

public class VisorPanel extends JPanel{
    private JLabel textVisor;
    private JLabel textVisor2;
    private JLabel exit;
    private Point initialClick;
    private JFrame parent;

    public VisorPanel(final JFrame parent){
        this.parent = parent;
        init();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                // localização da janela
                int thisX = parent.getLocation().x;
                int thisY = parent.getLocation().y;

                // determinar o quanto se moveu
                int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

                // mover para posição
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                parent.setLocation(X, Y);
            }
        });
    }

    public void init(){
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        topPanel.setVisible(true);
        topPanel.setOpaque(false);
        exit = new JLabel();
        switchExit(true);
        exit.setHorizontalAlignment(SwingConstants.LEFT);
        exit.setVerticalAlignment(SwingConstants.TOP);
        exit.setBorder(new EmptyBorder(5,7,0,2));
        topPanel.add(exit, BorderLayout.WEST);
        textVisor = new JLabel("0",SwingConstants.RIGHT);
        textVisor.setFont(new Font("HelveticaNeueLT Std Thin", Font.PLAIN, 55));
        textVisor.setForeground(new Color(0xffffff));
        textVisor.setBorder(new EmptyBorder(0,0,0,15));
        textVisor.setPreferredSize(new Dimension(235,105));
        add(textVisor, BorderLayout.EAST);
        textVisor2 = new JLabel("",SwingConstants.RIGHT);
        textVisor2.setFont(new Font("HelveticaNeueLT Std Thin", Font.PLAIN, 30));
        textVisor2.setForeground(new Color(0xffffff));
        textVisor2.setBorder(new EmptyBorder(5,0,0,20));
        textVisor2.setPreferredSize(new Dimension(100,35));
        topPanel.add(textVisor2, BorderLayout.CENTER);
    }

    /**
     * Troca de botão sair
     * @param Value
     */
    public void switchExit(boolean Value){
        String dir;
        if (Value)
            dir = "icons8-cancel-17-off.png";
        else
            dir = "icons8-cancel-17.png";
        BufferedImage imageBG = null;
        try {
            imageBG = ImageIO.read(getClass().getClassLoader().getResource("utfpr\\desktop\\calculator\\res\\icons\\" + dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit.setIcon(new ImageIcon(imageBG));
    }

    public JLabel getTextVisor() {
        return textVisor;
    }

    public JLabel getTextVisor2() {
        return textVisor2;
    }

    public JLabel getExit() {
        return exit;
    }

    public void setExit(JLabel exit) {
        this.exit = exit;
    }

}