package menudemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuDemo implements ActionListener {

  JLabel jlab;

  MenuDemo() {
    //CRIA UM CONTAINER
    JFrame jfrm = new JFrame("Menu Demo");

    //DEFINE O GERENCIADOR DE LAYOUT
    jfrm.setLayout(new FlowLayout());

    //DEFINE O TAMANHO DA JANELA
    jfrm.setSize(220, 200);

    //DEFINE A FORMA DE FECHAMENTO DA APLICAÇÃO
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //DEFINE UM RÓTULO
    jlab = new JLabel();

    //CRIA A BARRA DE MENUS 
    JMenuBar jmb = new JMenuBar();

    //CRIA MENU ARQUIVO
    //CRIA OS ITENS QUE COMPORÃO O MENU ARQUIVO
    JMenu jmArquivo = new JMenu("Arquivo");
    JMenuItem jmiAbrir = new JMenuItem("Abrir");
    JMenuItem jmiFechar = new JMenuItem("Fechar");
    JMenuItem jmiSalvar = new JMenuItem("Salvar");
    JMenuItem jmiSair = new JMenuItem("Sair");
    
    //ADICIONA OS ITENS DO MENU AO MENU ARQUIVO
    jmArquivo.add(jmiAbrir);
    jmArquivo.add(jmiFechar);
    jmArquivo.add(jmiSalvar);
    jmArquivo.addSeparator();
    jmArquivo.add(jmiSair);
    
    //ADICIONA O MENU ARQUIVO À BARRA DE MENUS
    jmb.add(jmArquivo);

    //CRIA O MENU OPÇÕES
    JMenu jmOpcoes = new JMenu("Opções");

    //CRIA O SUBMENU CORES
    JMenu jmCores = new JMenu("Cores");
    JMenuItem jmiVerme = new JMenuItem("Vermelha");
    JMenuItem jmiVerde = new JMenuItem("Verde");
    JMenuItem jmiAzul = new JMenuItem("Azul");
    
    //ADICIONA OS ITENS AO SUBMENU CORES
    jmCores.add(jmiVerme);
    jmCores.add(jmiVerde);
    jmCores.add(jmiAzul);
    
    //ADICIONA O SUBMENU CORES AO MENU OPÇÕES
    jmOpcoes.add(jmCores);

    //CRIANDO O SUBMENU PRIORIDADES
    JMenu jmPrioridade = new JMenu("Prioridade");
    JMenuItem jmiAlta = new JMenuItem("Alta");
    JMenuItem jmiBaixa = new JMenuItem("Baixa");
    
    //ADICIONA OS ITENS AO SUBMENU PRIORIDADES
    jmPrioridade.add(jmiAlta);
    jmPrioridade.add(jmiBaixa);
    
    //ADICIONANDO O SUBMENU PRIORIDADES AO MENU OPÇÕES
    jmOpcoes.add(jmPrioridade);

    //CRIANDO O SUBMENU RESET
    JMenuItem jmiReset = new JMenuItem("Reset");
    //ADICIONANDO O ITEM AO SUBMENU
    jmOpcoes.addSeparator();
    //ADICIONANDO O SUBMENU AO MENU OPÇÕES
    jmOpcoes.add(jmiReset);
    
    //ADICIONANDO O MENU OPÇÕES À BARRA DE MENU
    jmb.add(jmOpcoes);

    //CRIANDO O MENU AJUDA
    JMenu jmAjuda = new JMenu("Ajuda");
    JMenuItem jmiSobre = new JMenuItem("Sobre");
    //ADICIONANDO O ITEM AO SUBMENU
    jmAjuda.add(jmiSobre);
    //ADICIONANDO O SUBMENU AO MENU
    jmb.add(jmAjuda);

    //ADICIONANDO OS OUVINTES PARA OS MENUS
    jmiAbrir.addActionListener(this);
    jmiFechar.addActionListener(this);
    jmiSalvar.addActionListener(this);
    jmiSair.addActionListener(this);
    jmiVerme.addActionListener(this);
    jmiVerde.addActionListener(this);
    jmiAzul.addActionListener(this);
    jmiAlta.addActionListener(this);
    jmiBaixa.addActionListener(this);
    jmiReset.addActionListener(this);
    jmiSobre.addActionListener(this);

    //ADICIONANDO UM RÓTULO PARA O PAINEL DE CONTEÚDO
    jfrm.add(jlab);

    //ADICIONA UMA BARRA DE MENUS NO JFRAME
    jfrm.setJMenuBar(jmb);

    //EXIBE O JFRAME
    jfrm.setVisible(true);
  }

  //TRATADOR DOS EVENTOS DOS MENUS
  public void actionPerformed(ActionEvent ae) {
    //OBTEM O COMANDO DE AÇÃO DA SELEÇÃO FEITA NO MENU
    String comStr = ae.getActionCommand();

    //SE O USUÁRIO SELECIONAR SAIR, ENCERRA O PROGRAMA
    if(comStr.equals("Sair")) System.exit(0);

    //SENÃO, EXIBE A OPÇÃO SELECIONADA
    jlab.setText(comStr + " Selecionado");
  }

  public static void main(String[] args) {
    //cria a gui na thread de despacho de evento
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MenuDemo();
      }
    });
  }
}

