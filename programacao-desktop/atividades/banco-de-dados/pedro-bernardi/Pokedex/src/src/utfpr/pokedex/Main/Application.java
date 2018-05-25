/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utfpr.pokedex.Main;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import src.utfpr.pokedex.Model.DAO.PokemonDAO;
import src.utfpr.pokedex.View.PokemonForm;

/**
 *
 * @author Pedro Bernardi
 */
public class Application extends  JFrame{
    
    public static void main(String[] args) {
        Application app = new Application();
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setSize(new Dimension(1000, 700));
        app.add(new PokemonForm());
        app.setVisible(true);
    }
    
}
