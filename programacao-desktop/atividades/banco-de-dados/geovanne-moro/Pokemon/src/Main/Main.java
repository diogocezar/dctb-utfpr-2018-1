/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.InterfacePokemon;
import javax.swing.SwingUtilities;

/**
 *
 * @author geovannemoro
 */

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                InterfacePokemon iPokemon = new InterfacePokemon();
            }
        });
    }
}
