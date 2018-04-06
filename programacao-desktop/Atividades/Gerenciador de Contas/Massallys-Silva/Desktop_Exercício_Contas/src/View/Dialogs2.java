package View;

import javax.swing.JOptionPane;

public class Dialogs2{
    public static void main(String [] args){
            // declara-se as opções
        Object[] options = { "OK", "CANCELAR" };
            // chama-se o OptionDialog
        JOptionPane.showOptionDialog(null, "Clique OK para continuar", "Aviso",
        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
        
        null, options, options[0]);

        System.exit(0);
    }
}


