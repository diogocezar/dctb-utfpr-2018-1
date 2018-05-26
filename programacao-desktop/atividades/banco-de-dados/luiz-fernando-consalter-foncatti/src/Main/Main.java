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
 * @author luiz-
 */
public class Main extends JFrame{
    public static void main(String args[]){
        Main novaApp = new Main();
        novaApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        novaApp.setSize(new Dimension(800, 610));
        novaApp.add(new PokemonPanelForm());
        novaApp.setVisible(true);
    }
    
}
