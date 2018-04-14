/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacee;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author Aluno
 */
public class TesteComponentes implements ActionListener{
   
        public static final Dimension DIMENSOES = new Dimension(1000,700);
        JFrame janela = new JFrame();
        JLabel painel = new JLabel("<html>JScrollPane simplifies what would<br>" +
                 "otherwise be complicated tasks.<br>" +
                 "It can be used to scroll any lightweight <br>" +
                 "component or lightweight container. It is <br>" +
                 "especially useful when scrolling tables, lists,<br>" +
                 "or images.<br><br><br><br><br><br><br><br>");
        
        public void TesteComponente(){
            janela.setVisible(true);
            janela.setSize(DIMENSOES);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JScrollPane teste1 = new JScrollPane(painel);
            teste1.setBounds(1, 2, 150, 200);
            
            JButton teste2 = new JButton("Aperte");
            teste2.setBounds(210, 2, 100, 100);
            
            JToggleButton teste3 = new JToggleButton("Toggle");
            teste3.setBounds(320, 2, 100, 100);
            
            JCheckBox teste4 = new JCheckBox("Teste");
            teste4.setBounds(430, 2, 100, 100);
            
            JRadioButton teste5 = new JRadioButton("Teste2");
            teste5.setBounds(540, 2, 100, 100);
            
            JTextField teste6 = new JTextField();
            teste6.setToolTipText("Seu Nome");
            teste6.setBounds(1, 205, 200, 50);
            
            String[] numeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            JList teste7 = new JList(numeros);
            JScrollPane teste7_2 = new JScrollPane(teste7);
            teste7_2.setBounds(210, 205, 100, 100);
            
            String[] numeros2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            JComboBox teste8 = new JComboBox(numeros2);
            teste8.setBounds(320, 205, 50, 50);
            
            JLabel teste9 = new JLabel();
            teste9.setText("Biografia: ");
            teste9.setBounds(1, 290, 200, 100);
            
            JTextArea teste10 = new JTextArea();
            teste10.setToolTipText("Biografia");
            teste10.setBounds(1, 350, 100, 100);
            
            teste2.addActionListener(this);
            teste3.addActionListener(this);
            teste4.addActionListener(this);
            teste5.addActionListener(this);
            
            janela.add(teste1);
            janela.add(teste2);
            janela.add(teste3);
            janela.add(teste4);
            janela.add(teste5);
            janela.add(teste6);
            janela.add(teste7);
            janela.add(teste8);
            janela.add(teste9);
            janela.add(teste10);
        }
            public static void main(String args[]){
                TesteComponentes teste = new TesteComponentes();
                teste.TesteComponente();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame janela = new JFrame();
        janela.setLayout(new FlowLayout());
        janela.setSize(200, 200);
        JLabel painel = new JLabel("Você apertou o botão!");
        janela.add(BorderLayout.CENTER, painel);
        janela.setVisible(true);
    }
        
        

    
}
