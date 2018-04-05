package jcomboboxdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JComboBoxDemo {

    JComboBox<String> jcbb;
    JLabel jlab;

    //CRIANDO UM ARRAY DE MAÇÃS
    String[] apples = {"Winesap", "Cortland", "Red Delicious",
        "Golden Delicious", "Gala", "Fuji",
        "Granny Smith", "Jonathan"};

    JComboBoxDemo() {
        //CRIANDO UM NOVO CONTAINER 
        JFrame jfrm = new JFrame("Exemplo JComboBox");

        //ESPECIFICANDO O FLOWLYAOUT COMO GERENCIADOR 
        jfrm.setLayout(new FlowLayout());

        //ESPECIFICANDO O TAMANHO INICIAL DO JFRAME
        jfrm.setSize(380, 240);

        //ENCERRANDO A APLICAÇÃO
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CRIANDO O JCOMBOBOX
        jcbb = new JComboBox<String>(apples);

        //CRIANDO UM JLABEL
        jlab = new JLabel("Por favor, escolha uma maçã: ");

        //ADICIONANDO UM OUVINTE
        jcbb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //OBTENDO UMA REFERENCIA DO ITEM SELECIONADO
                String item = (String) jcbb.getSelectedItem();

                //MOSTRANDO O ITEM SELECIONADO
                jlab.setText("Seleção Atual: " + item);
            }
        });

        //ADICIONANDO O COMBO BOX E O LABEL AO JFRAME
        jfrm.add(jcbb);
        jfrm.add(jlab);

        //EXIBE O FRAME
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        //CRIA a GUI na thread de despacho de evento
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JComboBoxDemo();
            }
        });
    }
}
