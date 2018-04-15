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

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class Teste_JTable  extends JFrame{
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
       
    Object [][] dados = {
        {"AAAA", "43 99596-0000", "AAA@gmail.com"},
        {"BBBB", "43 99497-0100", "BBBB@hotmail.com"},
        {"CCCC", "43 99398-0200", "CCCC@gmail.com"}
    };
    
    String [] colunas = {"Nome", "Telefone", "Email"}; 
    

    public Teste_JTable() {
        super ("Contatos");
    }
    
    public void criaJanela(){
        
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem); 
        
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 120);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Teste_JTable C = new Teste_JTable();
        C.criaJanela();
    }
}

