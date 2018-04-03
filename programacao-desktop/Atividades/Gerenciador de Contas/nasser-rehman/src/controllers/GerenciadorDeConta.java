/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.ArrayList;
import models.Conta;
import models.DatabaseContas;
/**
 *
 * @author nasse
 */
public class GerenciadorDeConta 
{
    private static DatabaseContas db = new DatabaseContas();
    
    public GerenciadorDeConta()
    {
    }
    
    public String listarContas()
    {
        ArrayList<Conta> contas = db.getContas();
        String result = "";
        for(Conta conta: contas)
        {
            result += "Titular: "+conta.getTitular()+"| Conta: "+conta.getAgencia()+"\n";
        }
        
        return result;
    }
    
    public void removerConta(int numeroConta)
    {
       ArrayList<Conta> contas = db.getContas();
       for(Conta conta: contas)
       {
           if(conta.getNumero() == numeroConta)
           {
               db.getContas().remove(conta);
           }
       }
    }
    
    public void atualizarNomeDoTitular(int numeroConta, String novoNomeDoTitular)
    {
        ArrayList<Conta> contas = db.getContas();
        for(Conta conta: contas)
        {
            if(conta.getNumero() == numeroConta)
            {
                conta.setTitular(novoNomeDoTitular);
            }
        }
    }
    
    public String pesquisarAgencia(int numeroConta)
    {
        ArrayList<Conta> contas = db.getContas();
        for(Conta conta: contas)
        {
            if(conta.getNumero() == numeroConta)
            {
                return conta.getAgencia();
            }
        }
        
        return "Número de Conta não encontrada";
    }
    
    public double pesquisarSaldo(int numeroConta)
    {
        ArrayList<Conta> contas = db.getContas();
        for(Conta conta: contas) 
        {
            if(conta.getNumero() == numeroConta)
            {
                return conta.getSaldo();
            }
        }
        return 0;
    }
    
    public void criarConta(String titular, String agencia, int numero, double saldo)
    {
        db.addConta(new Conta(titular, agencia, numero, saldo));
    }
}
