package main;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.PokemonPanelForm;

/**
 *
 * @author christian
 */
public class Main extends JFrame {

    public static void main(String[] a) {
        Main form = new Main();
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form.setTitle("Cadastro de Pokemons");
        form.setResizable(false);
        form.setSize(new Dimension(620, 420));
        form.add(new PokemonPanelForm(form));
        form.setVisible(true);
    }
    
}
