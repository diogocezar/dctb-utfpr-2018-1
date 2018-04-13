/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_grafica_componentes;

/**
 *
 * @author Usuario
 */


import java.awt.*;  
import java.awt.event.*;  
  
import javax.swing.*;  
import javax.swing.tree.*;  
import javax.swing.event.*;  
  
import java.io.File; 

public class Teste_JTree extends JFrame {
     private JTree tree;
    public Teste_JTree()
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("arvore");
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetais");
        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Frutas");
        root.add(vegetableNode);
        root.add(fruitNode);
         
        tree = new JTree(root);
        add(tree);
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Exemplo");       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Teste_JTree();
            }
        });
    }       
     
}  

