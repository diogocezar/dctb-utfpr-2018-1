package jlistdemo;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

class JListDemo {

  JList<String> jlst;
  JLabel jlab;
  JScrollPane jscrlp;

  //CRIA UM ARRAY DE VARIEDADES DE MAÇÃS
  String[] apples = { "Winesap", "Cortland", "Red Delicious",
                      "Golden Delicious", "Gala", "Fuji",
                      "Granny Smith", "Jonathan" };

  JListDemo() {
    //CRIA UM NOVO JFRAME
    JFrame jfrm = new JFrame("exemplo de JList");

    //ESPECIFICA O GERENCIADOR
    jfrm.setLayout(new FlowLayout());

    //DEFINE O TAMANHO INICIAL DA JANELA
    jfrm.setSize(240, 200);

    //TERMINA A APLICAÇÃO
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //CRIA O JLIST
    jlst = new JList<String>(apples);

    //CONFIGURA A LISTA DE SELEÇÃO NO MODO DE SELEÇÃO SIMPLES
    jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    //ADICIONA LISTA A SCROLL PANE
    jscrlp = new JScrollPane(jlst);

    //CONFIGURA O TAMANHO PREFERENCIAL DE SCROLL PANE
    jscrlp.setPreferredSize(new Dimension(120, 90));

    //CRIA UM LABEL QUE MOSTRA A SELEÇÃO
    jlab = new JLabel("Por favor, escolha uma maça:");

    //ADCIONA UM OUVINTE PARA A LISTA
    jlst.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent le) {
        //OBTEM O INDICE DO ITEM ALTERADO
        int idx = jlst.getSelectedIndex();

        //APRESENTA A SELEÇÃO SE O ITEM FOI MODIFICADO
        if(idx != -1)
          jlab.setText("seleção atual: " + apples[idx]);
        else //SOLICITA NOVAMENTE
          jlab.setText("Por favor, escolha outra maçã: ");

      }
    });

    //ADICIONA A LISTA E O RÓTULO AO PAINEL DE CONTEÚDO
    jfrm.add(jscrlp);
    jfrm.add(jlab);

    //EXBIE O QUADRO
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    //CRIA a GUI na thread de despacho de evento
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JListDemo();
      }
    });
  }
}

