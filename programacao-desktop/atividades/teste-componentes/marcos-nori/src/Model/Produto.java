/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class Produto {
    
    public String codigo;
    public String nomeProduto;

    public Produto() {
    }

    public Produto(String codigo, String nomeProduto) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
     

}
