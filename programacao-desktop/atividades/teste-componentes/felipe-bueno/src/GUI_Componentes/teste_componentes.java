/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Componentes;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Felipe Bueno de Paula
 */
public class teste_componentes implements ActionListener{

    teste_componentes(){
        
        JFrame jfrm = new JFrame();
        
        jfrm.setLayout(null);
        
        jfrm.setSize(600, 600);
        
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel jlb = new JLabel("<html>JScrollPane simplifies what would<br>" +
                 "otherwise be complicated tasks.<br>" +
                 "It can be used to scroll any lightweight <br>" +
                 "component or lightweight container. It is <br>" +
                 "especially useful when scrolling tables, lists,<br>" +
                 "or images.<br><br><br><br><br><br><br><br>");
        
        
        JScrollPane jsp = new JScrollPane(jlb);
        jsp.setBounds(1, 2, 150, 200);
        
        JButton botaoA = new JButton("Aperte");
        botaoA.setBounds(203, 2, 100, 100);
        
        JToggleButton jtb = new JToggleButton("Toggle!");
        jtb.setBounds(304, 2, 100, 100);
        
        JCheckBox jcb = new JCheckBox("Teste");
        jcb.setBounds(405, 2, 100, 100);
        
        JRadioButton jrb = new JRadioButton("Teste2");
        jrb.setBounds(506, 2, 100, 100);
        
        JTextField jtf = new JTextField();
        jtf.setToolTipText("Seu Nome");
        jtf.setBounds(1, 205, 200, 50);
        
        String[] numeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        JList jl = new JList(numeros);
        JScrollPane jsp2 = new JScrollPane(jl);
        jsp2.setBounds(210, 205, 100, 100);
        
        String[] numeros2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        JComboBox Jcb = new JComboBox(numeros2);
        Jcb.setBounds(320, 205, 50, 50);
        
        JLabel jlb2 = new JLabel();
        jlb2.setText("Biografia: ");
        jlb2.setBounds(1, 290, 200, 100);
        JTextArea jta = new JTextArea();
        jta.setToolTipText("Biografia");
        jta.setBounds(1, 350, 100, 100);
        
        botaoA.addActionListener(this);
        jtb.addActionListener(this);
        jcb.addActionListener(this);
        jrb.addActionListener(this);
        
        jfrm.add(jsp);
        jfrm.add(botaoA);
        jfrm.add(jtb);
        jfrm.add(jcb);
        jfrm.add(jrb);
        jfrm.add(jtf);
        jfrm.add(jsp2);
        jfrm.add(Jcb);
        jfrm.add(jlb2);
        jfrm.add(jta);
                
        jfrm.setVisible(true);
    }
    
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                  new teste_componentes();  
                }     
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame jfrm = new JFrame();
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 100);
        JLabel jlab = new JLabel("Você apertou o botão!");
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }
}
