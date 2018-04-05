package exemplo3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextFieldDemo implements ActionListener {

    JTextField jtf; //OBJETO DO TIPO J TEXT FIELD - CAMPO DE TEXTO
    JLabel jlab; //OBJETO DO TIPO J LABEL - RÓTULO

    JTextFieldDemo() {

        //CRIANDO UM NOVO J FRAME = QUADRO/JANELA
        JFrame jfrm = new JFrame("Um simples exemplo de JTextField.");

        //ESPECIFICANDO FLOWLYATOU COMO GERENCIADOR DE LAYOUT
        jfrm.setLayout(new FlowLayout());

        //DEFININDO O TAMANHO INICIAL DA JANELA
        jfrm.setSize(300, 300);

        //TERMINANDO A APLICAÇÃO
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CRIANDO UMA INSTANCIA DE JTEXTFIELD COM TAMANHO 10
        jtf = new JTextField(10);

        //ADICIONANDO UM OUVINTE PARA JTEXTFIELD
        jtf.addActionListener(this);

        //ADICIONANDO O JTEXTFIELD AO JFRAME
        jfrm.add(jtf);

        //CRIANDO UM RÓTULO VAZIO
        jlab = new JLabel("");

        //ADICIONANDO O RÓTULO AO JFRAME
        jfrm.add(jlab);

        //APRESENTANDO O JFRAME NA TELA
        jfrm.setVisible(true);
    }

    //TRATADOR DE EVENTOS
    public void actionPerformed(ActionEvent ae) {

        //OBTÉM O TEXTO ATUAL QUE É MOSTRADO PELO JTEXTFIELD
        jlab.setText("Current contents: " + jtf.getText());
    }
}
