package View;

import javax.swing.JOptionPane;

public class Dialogs1{
    public static void main(String [] args){
            // mostra um diálogo de erro que exibe a mensagem "alerta"
        JOptionPane.showMessageDialog(null, "alerta", "alerta", JOptionPane.ERROR_MESSAGE);

            // mostra um painel de informação comas opções sim/não e a mensagem "escolha:"
        JOptionPane.showConfirmDialog(null, "escolha:", "escolha:", JOptionPane.YES_NO_OPTION);

        System.exit(0);
    }
}
