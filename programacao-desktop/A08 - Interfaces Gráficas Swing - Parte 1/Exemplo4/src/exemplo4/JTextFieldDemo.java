package exemplo4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JTextFieldDemo implements ActionListener {

    JTextField jtf1;
    JTextField jtf2;
    JLabel jlab;

    JTextFieldDemo() {
        JFrame jfrm = new JFrame("USANDO DOIS CAMPOS DE TEXTO");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(300, 300);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        
        //DEFININDO OS COMANDOS DE AÇÃO
        jtf1.setActionCommand("UM");
        jtf2.setActionCommand("DOIS");
        
        jtf1.addActionListener(this);
        jtf2.addActionListener(this);
        jfrm.add(jtf1);
        jfrm.add(jtf2);
        jlab = new JLabel("");
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("UM")) {
            jlab.setText("PRESSIONE ENTER PARA CAMPO DE TEXTO 1: "
                    + jtf1.getText());
        } else {
            jlab.setText("PRESSIONE ENTER PARA CAMPO DE TEXTO 2: "
                    + jtf2.getText());
        }
    }

}
