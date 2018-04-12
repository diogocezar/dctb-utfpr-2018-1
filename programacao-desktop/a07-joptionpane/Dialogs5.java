// importa a Classe JOptionPane
import javax.swing.JOptionPane;

public class Dialogs5{
	public static void main(String [] args){
		// mostra uma caixa de diálogo, solicitando que o usuário selecione um item.
        Object[] itens = { "MAÇA", "PERA", "BANANA" };
        Object selectedValue = JOptionPane.showInputDialog(null, "Escolha um item", "Opção", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);
        System.out.println(selectedValue);
        System.exit(0);
    }
}
