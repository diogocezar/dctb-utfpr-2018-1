package controllers;

// importa a Classe JOptionPane
import javax.swing.JOptionPane;

public class Dialogs4 {

    public static void main(String[] args) {
        // mostra uma caixa de diálogo, solicitando que o usuário informe algo.
        String inputValue = JOptionPane.showInputDialog("Digite algo:");
        System.out.println(inputValue);
        System.exit(0);
    }
}
