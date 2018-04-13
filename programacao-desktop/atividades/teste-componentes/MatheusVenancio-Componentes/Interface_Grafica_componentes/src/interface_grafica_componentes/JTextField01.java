/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_grafica_componentes;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class JTextField01 extends JFrame{
    
    JTextField caixa = new JTextField(20);
    public JTextField01(int par){
        setLayout(new FlowLayout());
        
        add(caixa);
        
        setTitle("COMPONENTES");
        setSize(700,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    public static void main(String[] args){
         JTextField01 teste =new  JTextField01(20); 
    }
}
