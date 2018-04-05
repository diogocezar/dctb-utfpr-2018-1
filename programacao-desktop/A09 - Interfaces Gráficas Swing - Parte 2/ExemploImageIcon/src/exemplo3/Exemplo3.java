package exemplo3;

import javax.swing.SwingUtilities;

public class Exemplo3 {

    public static void main(String[] args) {
        //CRIA a GUI na thread de despacho de evento
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JLabelDemo();
            }
        });
    }

}
