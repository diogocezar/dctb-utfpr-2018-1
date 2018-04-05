package jradiobuttondemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButtonDemo implements ActionListener {

    JLabel jlab;

    JRadioButtonDemo() {

        //CRIA UM NOVO JFRAME
        JFrame jfrm = new JFrame("EXEMPLO DE JRadioButton");

        //ESPECIFICA O GERENCIADOR DE LAYOUT
        jfrm.setLayout(new FlowLayout());

        //DEFINE O TAMANHO INICIAL DO FRAME
        jfrm.setSize(350, 100);

        //TERMINA O PROGRAMA QUANDO O USUÁRIO FECHA A APLICAÇÃO
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CRIA OS BOTÕES DE RÁDIO E ADICIONA AO PAINEL
        JRadioButton b1 = new JRadioButton("Debug");
        b1.addActionListener(this);
        jfrm.add(b1);

        JRadioButton b2 = new JRadioButton("velocidade máxima");
        b2.addActionListener(this);
        jfrm.add(b2);

        JRadioButton b3 = new JRadioButton("diminuir tamanho");
        b3.addActionListener(this);
        jfrm.add(b3);

        //DEFINE UM GRUPO DE BOTÕES
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);

        //CRIA UM LABEL E ADICIONA AO PAINEL
        jlab = new JLabel("selecione um");
        jfrm.add(jlab);

        //EXIBE O FRAME
        jfrm.setVisible(true);
    }

    //TRATADOR DE EVENTOS DO BOTÃO
    public void actionPerformed(ActionEvent ae) {
        jlab.setText("você selecionou:  " + ae.getActionCommand());
    }

    public static void main(String[] args) {       
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JRadioButtonDemo();
            }
        });
    }
}
