package interface_grafica_componentes;

import java.awt.*;
import java.awt.event.*;
import javafx.scene.control.ToggleButton;
import javax.swing.*;

public class Interface_Grafica_componentes extends JFrame {

    JButton B = new JButton("BOTÃO 1");

    public Interface_Grafica_componentes() {
        setLayout(null);
        B.setBounds(100, 50, 100, 60);
        add(B);
        setSize(300, 300);
        setTitle("Sistema botao ");
        JPanel painel = new JPanel();
        painel.setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Interface_Grafica_componentes teste = new Interface_Grafica_componentes();
    }

}
