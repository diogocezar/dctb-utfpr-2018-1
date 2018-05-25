/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.PokemonJPanelForm;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author igorv
 */
public class Main extends JFrame{
    public static void main(String args[]) {
       Main janela = new Main();
       janela.setSize(800,480);
       janela.add(new PokemonJPanelForm());
       janela.setVisible(true);
    }
}