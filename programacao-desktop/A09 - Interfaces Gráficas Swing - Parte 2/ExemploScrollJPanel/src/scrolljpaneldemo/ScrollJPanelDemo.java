package scrolljpaneldemo;
import java.awt.*;
import javax.swing.*;

class ScrollJPanelDemo {

  ScrollJPanelDemo() {

    //CRIA UM NOVO CONTAINER
    JFrame jfrm = new JFrame("rolando o painel");

    //define um tamanho inicial
    jfrm.setSize(280, 130);

    //termina a aplicação
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //cria um rótulo
    JLabel jlabOptions = new JLabel("Select one or more options: ");

    //cria vários botões de ckeck
    JCheckBox jcbOpt1 = new JCheckBox("Option One");
    JCheckBox jcbOpt2 = new JCheckBox("Option Two");
    JCheckBox jcbOpt3 = new JCheckBox("Option Three");
    JCheckBox jcbOpt4 = new JCheckBox("Option Four");
    JCheckBox jcbOpt5 = new JCheckBox("Option Five");
    JCheckBox jcbOpt6 = new JCheckBox("Option Six");
    JCheckBox jcbOpt7 = new JCheckBox("Option Seven");
    JCheckBox jcbOpt8 = new JCheckBox("Option Eight");
    JCheckBox jcbOpt9 = new JCheckBox("Option Nine");
    JCheckBox jcbOpt10 = new JCheckBox("Option Ten");

    //NENHUM TRATADOR DE EVENTOS É USADO POR ESTE EXEMPLO

    //CRIA UM JPANEL QUE CONTERÁ AS CAIXAS DE SELEÇÃO DAS OPÇÕES
    JPanel jpnl = new JPanel();
    jpnl.setLayout(new GridLayout(5, 3));

    //ADICIONA AS CAIXAS DE SELEÇÃO E O RÓTULO AO JPANEL
    jpnl.add(jlabOptions);
    jpnl.add(new JLabel("")); //rótulo de espaço reservado
    jpnl.add(new JLabel("")); //rótulo de espaço reservado

    jpnl.add(jcbOpt1);
    jpnl.add(jcbOpt2);
    jpnl.add(jcbOpt3);
    jpnl.add(jcbOpt4);
    jpnl.add(jcbOpt5);
    jpnl.add(jcbOpt6);
    jpnl.add(jcbOpt7);
    jpnl.add(jcbOpt8);
    jpnl.add(jcbOpt9);
    jpnl.add(jcbOpt10);

    //cria o painel de rolagem que rolará o outro painel
    JScrollPane jscrlp = new JScrollPane(jpnl);

    //adiciona o papel de rolagem ao quadro
    jfrm.add(jscrlp);

    //exbie o quadro
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new ScrollJPanelDemo();
      }
    });
  }
}

