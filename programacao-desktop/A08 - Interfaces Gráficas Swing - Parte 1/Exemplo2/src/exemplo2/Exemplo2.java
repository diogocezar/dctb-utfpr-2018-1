package exemplo2;

import javax.swing.SwingUtilities;

public class Exemplo2 {

    public static void main(String[] args) {

        //CRIA O QUADRO NA THREAD DE DESPACHO DE EVENTO
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JButtonDemo();
            }
        });
    }

}
