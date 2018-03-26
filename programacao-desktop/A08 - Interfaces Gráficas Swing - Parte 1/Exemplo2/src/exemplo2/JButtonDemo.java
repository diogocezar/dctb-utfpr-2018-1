package exemplo2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemo implements ActionListener {

    JLabel jlab;

    JButtonDemo() {

        //CRIA UM CONTEINER JFRAME
        JFrame jfrm = new JFrame("UM EXEMPLO DE BOTÃO");

        //ESPECIFICA FLOWLAYOUT COMO GERENCIADOR DE LAYOUT
        jfrm.setLayout(new FlowLayout());

        //FORNECE UM TAMANHO INICIAL PARA O QUADRO
        jfrm.setSize(300, 300);

        //ENCERRA O PROGRAMA QUANDO O USUÁRIO FECHA O APLICATIVO
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CRIA DOIS BOTÕES
        JButton jbtnFirst = new JButton("PRIMEIRO");
        JButton jbtnSecond = new JButton("SEGUNDO");

        //ADICIONA OUVINTES DE AÇÃO
        jbtnFirst.addActionListener(this);
        jbtnSecond.addActionListener(this);

        //ADICIONA OS BOTÕES AO PAINEL DE CONTEÚDO
        jfrm.add(jbtnFirst);
        jfrm.add(jbtnSecond);

        //CRIA UM RÓTULO
        jlab = new JLabel("PRESSIONE O BOTÃO");

        //ADICIONA O RÓTULO AO QUADRO
        jfrm.add(jlab);

        //EXIBE O QUADRO
        jfrm.setVisible(true);
    }

    //TRATADOR DE EVENTOS DO BOTÃO
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("PRIMEIRO")) {
            jlab.setText("O PRIMEIRO BOTÃO FOI PRESSIONADO.");
        } else {
            jlab.setText("O SEGUNDO BOTÃO FOI PRESSIONADO. ");
        }
    }
}