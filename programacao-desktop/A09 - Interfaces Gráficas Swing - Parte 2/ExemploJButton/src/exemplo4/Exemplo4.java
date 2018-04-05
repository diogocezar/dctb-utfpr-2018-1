package exemplo4;

import javax.swing.SwingUtilities;

/*
 * @author Cissa Gatto
 */
public class Exemplo4 {

    public static void main(String[] args) {
        //CRIA a GUI na thread de despacho de evento
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JButtonDemo();
            }
        });
    }

}
