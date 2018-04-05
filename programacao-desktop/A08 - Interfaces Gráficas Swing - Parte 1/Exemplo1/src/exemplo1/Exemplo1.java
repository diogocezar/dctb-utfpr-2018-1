package exemplo1;

import javax.swing.SwingUtilities;

public class Exemplo1 {

    public static void main(String[] args) {

        //CRIA O QUADRO NA THREAD DE DESPACHO DE EVENTO
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingDemo(); //CRIA A GUI NA THREAD DE DESPACHO DE EVENTO
                new SwingDemo(); //CRIA A GUI NA THREAD DE DESPACHO DE EVENTO
            }
        });
    }

}
