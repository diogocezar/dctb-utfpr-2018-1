/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author nasse
 */
public class DatabaseContas {
    private ArrayList<Conta> contas = new ArrayList<>();
    
    
    public DatabaseContas(){
        
    }
    
    public ArrayList<Conta> getContas()
    {
        return this.contas;
    }
    
    public void setConta(ArrayList<Conta> contas)
    {
        this.contas = contas;
    }
    
    public void addConta(Conta conta)
    {
        contas.add(conta);
    }
}
