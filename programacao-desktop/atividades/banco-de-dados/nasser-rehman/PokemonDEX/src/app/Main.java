/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import views.MainPanelForm;
import views.PokemonPanelForm;

/**
 *
 * @author nadook
 */
public class Main extends JFrame {
    public static void main(String args[]) {
        Main main = new Main();
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setSize(new Dimension(500, 236));
        main.add(new MainPanelForm(main));
        main.setResizable(false);
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }
}
