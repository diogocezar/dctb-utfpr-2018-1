/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.itsone.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import utfpr.itsone.data.controller.config.BinArq;
import utfpr.itsone.data.controller.config.JsonArq;
import utfpr.itsone.data.controller.config.TextArq;
import utfpr.itsone.view.login.SignIn;
import utfpr.itsone.view.login.SignUp;

/**
 *
 * @author Vinicius
 */
public class Index extends JFrame {

    public static final String NAME = "ManipArq - TA";
    public static final Dimension DIMENSIONS = new Dimension(500, 500);
    private Point initialClick;
    private final JFrame parent = this;
    private JCheckBoxMenuItem saveMenu;
    private ButtonGroup group;
    private JLabel val = new JLabel();
    private JPanel content = new JPanel(new BorderLayout());

    public Index() throws HeadlessException {
        super(NAME);
        setUndecorated(true);
        setPreferredSize(DIMENSIONS);
        revalidate();
        setLayout(new BorderLayout());
        init();
        mount(true);
        pack();
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        JPanel topMenu = new JPanel(new BorderLayout());
        JPanel menu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel exit = new JLabel();
        
        add(topMenu, BorderLayout.NORTH);
        
        topMenu.add(menu, BorderLayout.EAST);
        switchExit(false, exit, "icons8-cancel-20");
        topMenu.setBackground(new Color(0x000715));
        
        menu.setOpaque(false);
        menu.add(exit);
        
        exit.addMouseListener(new MouseAdapter() {
            String path = "icons8-cancel-20";

            public void mouseEntered(MouseEvent e) {
                switchExit(true, exit, path);
            }

            public void mouseExited(MouseEvent e) {
                switchExit(false, exit, path);
            }

            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        topMenu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        val.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JLabel value = (JLabel) e.getSource();
                if (value.getText().equals("Logar")) {
                    mount(true);
                } else {
                    mount(false);
                }
            }
        });
        
        val.setBorder(new EmptyBorder(0, 220, 15, 0));
        val.setBackground(new Color(0x000a1f));
        val.setForeground(Color.WHITE);
        val.setOpaque(true);

        topMenu.addMouseMotionListener(new MouseMotionAdapter() {
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

        JMenuBar menuBar = new JMenuBar();

        JPanel menuLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topMenu.add(menuLeft, BorderLayout.WEST);
        menuLeft.setOpaque(false);
        menuLeft.add(menuBar);
        menuBar.setBackground(Color.white);
        menuBar.setForeground(Color.black);

        JMenu modeMenu = new JMenu("Modo");
        JMenu recMenu = new JMenu("Recuperar");
        saveMenu = new JCheckBoxMenuItem("Salvar");
        modeMenu.setBackground(Color.WHITE);
        recMenu.setBackground(Color.WHITE);
        saveMenu.setSelected(true);
        menuBar.add(modeMenu);
        menuBar.add(recMenu);
        menuBar.add(saveMenu);

        recMenu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                String actionCommand = group.getSelection().getActionCommand();
            if(actionCommand.equals("text"))
                new TextArq().read();
            if(actionCommand.equals("bin"))
                new BinArq().read();
            if(actionCommand.equals("json"))
                new JsonArq().read();
            
            showMessageDialog(null, "Você recuperou os usuários no modo " + actionCommand);
            }
        });
       
        JRadioButtonMenuItem json = new JRadioButtonMenuItem("JSON");
        json.setHorizontalTextPosition(JMenuItem.RIGHT);
        json.setActionCommand("json");
        JRadioButtonMenuItem bin = new JRadioButtonMenuItem("BINARIO");
        bin.setHorizontalTextPosition(JMenuItem.RIGHT);
        bin.setActionCommand("bin");
        JRadioButtonMenuItem text = new JRadioButtonMenuItem("TEXTO");
        text.setHorizontalTextPosition(JMenuItem.RIGHT);
        text.setActionCommand("text");

        group = new ButtonGroup();
        group.add(json);
        group.add(bin);
        group.add(text);
  
        json.setSelected(true);
        modeMenu.add(json);
        modeMenu.add(bin);
        modeMenu.add(text);

        add(content, BorderLayout.CENTER);
    }

    public void switchExit(boolean Value, JLabel action, String path) {
        action.setIcon(new ImageIcon(setImage("utfpr/itsone/resources/icons/" + path + (Value ? "-off" : "") + ".png")));
    }

    public BufferedImage setImage(String path) {
        try {
            return ImageIO.read(getClass().getClassLoader().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void mount(boolean switchMode) {
        if (switchMode) {
            content.removeAll();
            openSignIn();
            val.setText("Registrar");
            val.setBorder(new EmptyBorder(0, 220, 15, 0));
            add(val, BorderLayout.SOUTH);
        } else {
            content.removeAll();
            openSignUp();
            val.setText("Logar");
            val.setBorder(new EmptyBorder(0, 230, 15, 0));
            add(val, BorderLayout.SOUTH);
        }
    }

    public void openSignIn() {
        content.add(new SignIn(this), BorderLayout.CENTER);
    }

    public void openSignUp() {
        content.add(new SignUp(this, saveMenu.isSelected(), group), BorderLayout.CENTER);
    }

}
