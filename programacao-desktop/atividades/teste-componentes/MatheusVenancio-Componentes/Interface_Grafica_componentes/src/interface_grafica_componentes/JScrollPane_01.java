package interface_grafica_componentes;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author Usuario
 */
public class JScrollPane_01 extends JFrame{

    JLabel imagem = new JLabel(new ImageIcon(getClass().getResource("AA.jpg")));
    JScrollPane a =new JScrollPane(imagem);
    public JScrollPane_01(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        setVisible(true);
                
        add(a);
        
               
    }

    public static void main(String[] args){
        JScrollPane_01 teste = new JScrollPane_01();
    }
}
