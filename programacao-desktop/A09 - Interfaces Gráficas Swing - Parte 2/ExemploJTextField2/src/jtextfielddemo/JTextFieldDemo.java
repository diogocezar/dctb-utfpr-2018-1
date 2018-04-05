package jtextfielddemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JTextFieldDemo {

  JLabel jlabAll;
  JLabel jlabSelected;

  JTextField jtf;

  JButton jbtnCut;
  JButton jbtnPaste;

  public JTextFieldDemo() {

    //CRIA UM NOVO CONTAINER
    JFrame jfrm = new JFrame("JTextField Example");

    //ESPECIFICA O GERENCIADOR DE LAYOUT
    jfrm.setLayout(new FlowLayout());

    //ESPECIFICA O TAMANHO INICIAL DO FRAME
    jfrm.setSize(200, 150);

    //FECHA A APLICAÇÃO
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //CRIA OS RÓTULOS
    jlabAll = new JLabel("Todo o Texto: ");
    jlabSelected = new JLabel("Texto selecionado: ");

    //CRIA O CAMPO DE TEXTO
    jtf = new JTextField("isto é um teste.", 15);
    
    //ADICIONA UM OUVINTE PARA O CAMPO DE TEXTO
    //sempre que o usuário pressionar enter, o conteúdo
    //do campo será exibido. qualquer texto selecionado
    //atualmente também será exibido
    jtf.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
          //sempre que o usuário pressionar enter, exibirá o texto inteiro
          //e qualquer texto selecionado
        jlabAll.setText("Todo texto: " + jtf.getText());
        if(jtf.getSelectedText() != null)
          jlabSelected.setText("Texto selecionado: " +
                               jtf.getSelectedText());
      }
    });

    //cria os botões recortar e colar
    jbtnCut = new JButton("Recortar");
    jbtnPaste = new JButton("Colar");

    //adiciona um ouvinte para o botão recortar
    jbtnCut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        //recorta o texto selecionado e o insere na area de transferncia
        jtf.cut();
        jlabAll.setText("Todo Texto: " + jtf.getText());
        if(jtf.getSelectedText() != null)
          jlabSelected.setText("Texto Selecionado: " +
                               jtf.getSelectedText());
      }
    });

    //adiciona um ouvinte para o botão colar
    jbtnPaste.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        //cola o texto da área de transferencia no campo de texto
        jtf.paste();
      }
    });

    //adiciona os componentes ao painel de conteúdo
    jfrm.add(jtf);
    jfrm.add(jbtnCut);
    jfrm.add(jbtnPaste);
    jfrm.add(jlabAll);
    jfrm.add(jlabSelected);

    //exibe o frame
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JTextFieldDemo();
      }
    });
  }
}