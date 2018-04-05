package jscrollpanedemo;

import javax.swing.*;

class JScrollPaneDemo {

  JScrollPaneDemo() {

    //CRIA UM NOVO CONTAINER
    JFrame jfrm = new JFrame("EXEMPLO DE JScrollPane");

    //DEFINE UM TAMANHO INICIAL PARA O FRAME
    jfrm.setSize(200, 120);

    //FECHA A APLICAÇÃO QUANDO O USUÁRIO SAI
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //CRIA UM RÓTULO LONGO BASEADO EM HTML
    JLabel jlab =
      new JLabel("<html>JScrollPane simplifies what would<br>" +
                 "otherwise be complicated tasks.<br>" +
                 "It can be used to scroll any lightweight <br>" +
                 "component or lightweight container. It is <br>" +
                 "especially useful when scrolling tables, lists,<br>" +
                 "or images.");

    //CRIA UM PAINEL DE ROLAGEM E FAZ ROLAR O RÓTULO
    JScrollPane jscrlp = new JScrollPane(jlab);

    //ADICIONA O PAINEL DE ROLAGEM AO FRAME
    jfrm.add(jscrlp);

    //EXBIE O FRAME
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JScrollPaneDemo();
      }
    });
  }
}
