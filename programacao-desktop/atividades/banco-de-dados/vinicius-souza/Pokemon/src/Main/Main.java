package Main;

import View.*;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main extends JFrame{
    public static void main(String args[]) {
        Main me = new Main();
        me.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        me.setSize(new Dimension(700, 600));
        me.add(new PokemonPanelForm());
        me.setVisible(true);
    }
}
