package exemplo5;

import javax.swing.SwingUtilities;

/*
 * @author Cissa Gatto
 */
public class Exemplo5 {

    public static void main(String[] args) {
        // Create the GUI on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JToggleButtonDemo();
            }
        });
    }

}
