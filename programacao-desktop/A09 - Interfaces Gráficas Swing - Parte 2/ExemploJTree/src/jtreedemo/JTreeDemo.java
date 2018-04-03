package jtreedemo;

import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class JTreeDemo {

    JTree tree;
    JLabel jlab;

    JTreeDemo() {

        //cria um novo container
        JFrame jfrm = new JFrame("exemplo de JTree");

        //define o tamanho incial
        jfrm.setSize(300, 240);

        //termina a aplicação
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //cria um nó raiz para a arvore
        DefaultMutableTreeNode root
                = new DefaultMutableTreeNode("Java Keywords");

        //cria uma subarvore para tipos
        DefaultMutableTreeNode types = new DefaultMutableTreeNode("tipos");
        root.add(types);

        //cria uma subarvore para tipos de ponto flutuante
        DefaultMutableTreeNode fpTypes
                = new DefaultMutableTreeNode("ponto flutuante");
        types.add(fpTypes);
        fpTypes.add(new DefaultMutableTreeNode("float"));
        fpTypes.add(new DefaultMutableTreeNode("double"));

        //CRIA subarvore para tipos inteiros
        DefaultMutableTreeNode intTypes
                = new DefaultMutableTreeNode("inteiros");
        types.add(intTypes);
        intTypes.add(new DefaultMutableTreeNode("byte"));
        intTypes.add(new DefaultMutableTreeNode("short"));
        intTypes.add(new DefaultMutableTreeNode("int"));
        intTypes.add(new DefaultMutableTreeNode("long"));

        //cria nós para caracteres e booleanos
        types.add(new DefaultMutableTreeNode("char"));
        types.add(new DefaultMutableTreeNode("boolean"));

        //cria subarvores para loops
        DefaultMutableTreeNode loops = new DefaultMutableTreeNode("Loops");
        root.add(loops);
        loops.add(new DefaultMutableTreeNode("for"));
        loops.add(new DefaultMutableTreeNode("while"));
        loops.add(new DefaultMutableTreeNode("do"));

        //cria a arvore
        tree = new JTree(root);

        //adiciona a arvore ao painel de rolagem Add the tree to a scroll pane.
        JScrollPane jsp = new JScrollPane(tree);

        //adiciona o painel de rolagem a o centro de border layout padrão
        jfrm.add(jsp);

        //adciona o rótulo a região sul do border layout padrão
        jlab = new JLabel("SELECIONA A PARTIR DA ÁRVORE.");
        jfrm.add(jlab, BorderLayout.SOUTH);

        //tratador de eventos de seleção da arvore
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent tse) {
                jlab.setText("a seleção é: "
                        + tse.getPath().getLastPathComponent());
            }
        });

        //exibe o quadro
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTreeDemo();
            }
        });
    }
}
