package jcheckboxdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCheckBoxDemo implements ItemListener {
  JLabel jlabChange;
  JLabel jlabSupported;

  JCheckBox cbWin;
  JCheckBox cbLinux;
  JCheckBox cbMac;

  JCheckBoxDemo() {
    //CRIA UM NOVO CONTAINER JFRAME
    JFrame jfrm = new JFrame("Exemplo de JCheckBox");

    //ESPECIFICA FLOWLAYOUT COMO O GERENCIADOR
    jfrm.setLayout(new FlowLayout());

    //ESPECIFICA O TAMANHO INICIAL DA JANELA
    jfrm.setSize(340, 140);

    //TERMINA O PROGRAMA FECHANDO A APLICAÇÃO
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //ADICIONA AS CAIXAS DE SELEÇÃO AO PAINEL DE CONTEUDO
    cbWin = new JCheckBox("Windows");
    cbWin.addItemListener(this);
    jfrm.add(cbWin);

    cbLinux = new JCheckBox("Linux");
    cbLinux.addItemListener(this);
    jfrm.add(cbLinux);

    cbMac = new JCheckBox("Mac OS");
    cbMac.addItemListener(this);
    jfrm.add(cbMac);

    //CRIA OS RÓTULOS
    jlabChange = new JLabel("Selecione o Sistema Operacional: ");
    jfrm.add(jlabChange);

    jlabSupported = new JLabel();
    jfrm.add(jlabSupported);

    //EXIBE O QUADRO
    jfrm.setVisible(true);
  }

  // Handle item events for the check boxes.
  public void itemStateChanged(ItemEvent ie) {
    JCheckBox cb = (JCheckBox)ie.getItem();

    if(cb.isSelected())
      jlabChange.setText(cb.getText() + " selecionado");
    else
      jlabChange.setText(cb.getText() + " deselecionado");

    // Build a string the indicate all selections.
    String supported = "Suporte Sistema Operacional: ";
    if(cbWin.isSelected()) supported += "Windows  ";
    if(cbLinux.isSelected()) supported += "Linux  ";
    if(cbMac.isSelected()) supported += "Mac OS";

    jlabSupported.setText(supported);
  }

  public static void main(String[] args) {

    //CRIA a GUI na thread de despacho de evento
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JCheckBoxDemo();
      }
    });
  }
}
