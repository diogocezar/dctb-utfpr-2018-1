package interface_grafica_componentes;

import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class Teste_JCheck extends JFrame {

    private JCheckBox java, php, csharp, c;
    public Teste_JCheck() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setLayout(new FlowLayout());

        java = new JCheckBox("Java");
        php = new JCheckBox("PHP");
        csharp = new JCheckBox("C#");
        c = new JCheckBox("C");

        add(java);
        add(php);
        add(csharp);
        add(c);
        setVisible(true);

    }
    public static void main(String[] args) {
        Teste_JCheck teste = new Teste_JCheck();
    }
}
