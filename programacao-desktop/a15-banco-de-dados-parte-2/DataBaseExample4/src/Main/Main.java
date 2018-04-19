package Main;

import View.PanelForm;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Main extends JFrame{
    public static void main(String args[]) {
        Main me = new Main();
        me.setSize(new Dimension(500, 410));
        me.add(new PanelForm());
        me.setVisible(true);
    }
}