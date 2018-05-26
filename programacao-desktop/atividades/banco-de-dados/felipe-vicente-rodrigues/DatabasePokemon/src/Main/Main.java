/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.PokemonPanelForm;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author felipe
 */
public class Main extends JFrame {

    public static void main(String args[]) {
        Main me = new Main();
        me.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        me.setSize(new Dimension(500, 410));
        me.add(new PokemonPanelForm());
        me.setVisible(true);
    }

}
