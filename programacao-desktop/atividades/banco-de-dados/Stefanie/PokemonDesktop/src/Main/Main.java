package Main;

import View.PokemonPanelForm;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main extends JFrame{
    public static void main(String args[]) {
        Main me = new Main();
        me.setTitle("Trabalho de desktop - Stefanie");
        me.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        me.setSize(new Dimension(600, 590));
        me.add(new PokemonPanelForm());
        me.setResizable(false);
        me.setLocationRelativeTo(null);
        me.setVisible(true);
        
        
    }
}