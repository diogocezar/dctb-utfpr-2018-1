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

        //CRIA MENU ARQUIVO COM MNEMONICO E ACELERADOR      
        JMenu jmArquivo = new JMenu("Arquivo");
        jmArquivo.setMnemonic(KeyEvent.VK_A);

        //CRIANDO OS ITENS DO MENU COM MNEMONICOS E ACELERADORES
        JMenuItem jmiAbrir = new JMenuItem("Abrir", KeyEvent.VK_B);
        jmiAbrir.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiFechar = new JMenuItem("Fechar", KeyEvent.VK_F);
        jmiFechar.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiSalvar = new JMenuItem("Salvar", KeyEvent.VK_S);
        jmiSalvar.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiSair = new JMenuItem("Sair", KeyEvent.VK_I);
        jmiSair.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));

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
        jmOpcoes.setMnemonic(KeyEvent.VK_O);

        //CRIA O SUBMENU CORES
        JMenu jmCores = new JMenu("Cores");
        jmCores.setMnemonic(KeyEvent.VK_C);

        JMenuItem jmiVerme = new JMenuItem("Vermelha");
        jmiVerme.setMnemonic(KeyEvent.VK_V);
        jmiVerme.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiVerde = new JMenuItem("Verde");
        jmiVerde.setMnemonic(KeyEvent.VK_E);
        jmiVerde.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiAzul = new JMenuItem("Azul");
        jmiAzul.setMnemonic(KeyEvent.VK_Z);
        jmiAzul.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));

        //ADICIONA OS ITENS AO SUBMENU CORES
        jmCores.add(jmiVerme);
        jmCores.add(jmiVerde);
        jmCores.add(jmiAzul);

        //ADICIONA O SUBMENU CORES AO MENU OPÇÕES
        jmOpcoes.add(jmCores);

        //CRIANDO O SUBMENU PRIORIDADES
        JMenu jmPrioridade = new JMenu("Prioridade");
        jmPrioridade.setMnemonic(KeyEvent.VK_P);

        JMenuItem jmiAlta = new JMenuItem("Alta");
        jmiAlta.setMnemonic(KeyEvent.VK_L);
        jmiAlta.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiBaixa = new JMenuItem("Baixa");
        jmiBaixa.setMnemonic(KeyEvent.VK_X);
        jmiBaixa.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

        //ADICIONA OS ITENS AO SUBMENU PRIORIDADES
        jmPrioridade.add(jmiAlta);
        jmPrioridade.add(jmiBaixa);

        //ADICIONANDO O SUBMENU PRIORIDADES AO MENU OPÇÕES
        jmOpcoes.add(jmPrioridade);

        //CRIANDO O SUBMENU RESET
        JMenuItem jmiReset = new JMenuItem("Reset");
        jmiReset.setMnemonic(KeyEvent.VK_T);
        jmiReset.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));

        //ADICIONANDO O ITEM AO SUBMENU
        jmOpcoes.addSeparator();
        //ADICIONANDO O SUBMENU AO MENU OPÇÕES
        jmOpcoes.add(jmiReset);

        //ADICIONANDO O MENU OPÇÕES À BARRA DE MENU
        jmb.add(jmOpcoes);

        //CRIANDO O MENU AJUDA
        JMenu jmAjuda = new JMenu("Ajuda");
        jmiReset.setMnemonic(KeyEvent.VK_J);

        JMenuItem jmiSobre = new JMenuItem("Sobre");
        jmiReset.setMnemonic(KeyEvent.VK_W);
        jmiReset.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
        
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
        if (comStr.equals("Sair")) {
            System.exit(0);
        }

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

