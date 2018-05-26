/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.Main;

import pokemon.View.View;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Danilo
 */
public class Main extends JFrame {
    public static void main(String args[]) {
        Main me = new Main();
        me.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        me.setSize(new Dimension(700, 700));
        me.add(new View());
        me.setVisible(true);
    }
}
