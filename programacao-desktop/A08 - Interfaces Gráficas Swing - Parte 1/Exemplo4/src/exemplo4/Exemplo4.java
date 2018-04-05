package exemplo4;

import javax.swing.SwingUtilities;

public class Exemplo4 {

    public static void main(String[] args) {
        //CRIANDO O FRAME
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTextFieldDemo();
            }
        });
    }

}
