package dynmenudemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DynMenuDemo implements ActionListener {

  JLabel jlab;
  JMenuItem jmiAmarelo;
  JMenuItem jmiLilas;
  JMenuItem jmiLaranja;
  JMenu jmCores;

  DynMenuDemo() {
    JFrame jfrm = new JFrame("Menu Dinamico");
    jfrm.setLayout(new FlowLayout());
    jfrm.setSize(220, 200);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //CRIANDO O RÓTULO QUE MOSTRARÁ A SELEÇÃO DE MENU    
    jlab = new JLabel();

    //CRIANDO A BARRA DE MENUS
    JMenuBar jmb = new JMenuBar();

    //CRIANDO O MENU DE ARQUIVOS
    JMenu jmArquivo = new JMenu("Arquivo");
    JMenuItem jmiAbrir = new JMenuItem("Abrir");
    JMenuItem jmiFechar = new JMenuItem("Fechar");
    JMenuItem jmiSalvar = new JMenuItem("Salvar");
    JMenuItem jmiSair = new JMenuItem("Sair");
    jmArquivo.add(jmiAbrir);
    jmArquivo.add(jmiFechar);
    jmArquivo.add(jmiSalvar);
    jmArquivo.addSeparator();
    jmArquivo.add(jmiSair);
    jmb.add(jmArquivo);

    //CRIANDO O MENU DE OPÇÕES
    JMenu jmOpcoes = new JMenu("Opções");

    //CRIANDO O SUBMENU DE CORES
    jmCores = new JMenu("Cores");
    JMenuItem jmiVerm = new JMenuItem("Vermelho");
    JMenuItem jmiVerde = new JMenuItem("Verde");
    JMenuItem jmiAzul = new JMenuItem("Azul");
    jmCores.add(jmiVerm);
    jmCores.add(jmiVerde);
    jmCores.add(jmiAzul);

    //CRIANDO MAIS OPÇOES DE CORES
    JMenuItem jmiMaisMenos = new JMenuItem("Mais Cores");
    jmCores.add(jmiMaisMenos);

    //ADICIONADO CORES NO MENU
    jmOpcoes.add(jmCores);

    //criando cores adicionais 
    //estas serão adicionadas ou removidas sob demanda
    jmiAmarelo = new JMenuItem("Amarelo");
    jmiLilas = new JMenuItem("Lilás");
    jmiLaranja = new JMenuItem("Laranja");

    //CRIANDO O SUBMENU PRIORIDADE
    JMenu jmPrioridade = new JMenu("Prioridade");
    JMenuItem jmiAlta = new JMenuItem("Alta");
    JMenuItem jmiBaixa = new JMenuItem("Baixa");
    jmPrioridade.add(jmiAlta);
    jmPrioridade.add(jmiBaixa);

    //ADICIONADO OS ITENS AO MENU
    jmOpcoes.add(jmPrioridade);

    //CRIANDO O SUBMENU RESET
    JMenuItem jmiReset = new JMenuItem("Reset");
    jmOpcoes.addSeparator();
    jmOpcoes.add(jmiReset);

    //ADICIONANDO AO MENU PRINCIPAL
    jmb.add(jmOpcoes);

    //criando o menu de ajuda
    JMenu jmAjuda = new JMenu("Ajuda");
    JMenuItem jmiSobre = new JMenuItem("Sobre");
    jmAjuda.add(jmiSobre);
    jmb.add(jmAjuda);

    //ADICIONANDO OS OUVINTES PARA CADA ITEM DE MENU
    jmiAbrir.addActionListener(this);
    jmiFechar.addActionListener(this);
    jmiSalvar.addActionListener(this);
    jmiSair.addActionListener(this);
    jmiVerm.addActionListener(this);
    jmiVerde.addActionListener(this);
    jmiAzul.addActionListener(this);
    jmiAlta.addActionListener(this);
    jmiBaixa.addActionListener(this);
    jmiReset.addActionListener(this);
    jmiSobre.addActionListener(this);

    //ADICIONANDO OS OUVINTES PARA CORES ADICIONAIS
    jmiMaisMenos.addActionListener(this);
    jmiAmarelo.addActionListener(this);
    jmiLilas.addActionListener(this);
    jmiLaranja.addActionListener(this);

    //ADICIONANDO O RÓTULO AO PAINEL DE CONTEÚDO 
    jfrm.add(jlab);

    //ADICIONANDO A BARRA DE FERRAMENTAS AO FRAME
    jfrm.setJMenuBar(jmb);

    jfrm.setVisible(true);
  }

  //TRATADOR DE EVENTOS
  public void actionPerformed(ActionEvent ae) {
    //OBTEM O COMANDO DE AÇÃO
    String comStr = ae.getActionCommand();

    //se o usuario escolher sair, então, sai do programa
    if(comStr.equals("Sair"))
      System.exit(0);
    else if(comStr.equals("Mais Cores")) {
      jmCores.add(jmiAmarelo);
      jmCores.add(jmiLilas);
      jmCores.add(jmiLaranja);
      JMenuItem mi = (JMenuItem) ae.getSource();
      mi.setText("Menos Cores");
    } else if(comStr.equals("Menos Cores")) {
      jmCores.remove(jmiAmarelo);
      jmCores.remove(jmiLilas);
      jmCores.remove(jmiLaranja);
      JMenuItem mi = (JMenuItem) ae.getSource();
      mi.setText("Mais Cores");
    }

    //MOSTRA O ITEM SELECIONADO
    jlab.setText(comStr + " Selecionado");
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new DynMenuDemo();
      }
    });
  }
}
