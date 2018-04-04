/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import model.Conta;
import model.Database;

/**
 *
 * @author ecsanchesjr
 */
public class GerenciadorDeContas {
    public String listarContas(){
        String contasStr="";
        ArrayList<Conta> contas = Database.getInstance().getContas();
        for (Conta conta: contas){
            contasStr+= "Titular: "+ conta.getNomeTitular() + " Conta: "+ conta.getNumConta()+ " \n";
        }
        return contasStr;
    }
    
    public boolean removerConta(int numeroConta){
        ArrayList<Conta> contas = Database.getInstance().getContas();
        for(Conta conta: contas){
            if(conta.getNumConta()==numeroConta){
                Database.getInstance().getContas().remove(conta);
                return true;
            }
        }
        return false;
    }
    
    public boolean atualizarNomeDoTitular(int numeroConta,String novoNomeTitular){
        ArrayList<Conta> contas= Database.getInstance().getContas();
        for(Conta conta: contas){
            if(conta.getNumConta()==numeroConta){
                conta.setNomeTitular(novoNomeTitular);
                return true;
            }
        }
        return false;
    }
    
    public String pesquisarAgencia(int numeroConta){
        ArrayList<Conta> contas = Database.getInstance().getContas();
        for(Conta conta: contas){
            if(conta.getNumConta()==numeroConta){
                return conta.getAgencia();
            }
        }
        return null;
    }
    
    public double pesquisarSaldo(int numeroConta){
        ArrayList<Conta> contas = Database.getInstance().getContas();
        for(Conta conta:contas){
            if(conta.getNumConta()==numeroConta){
                return conta.getSaldo();
            }
        }
        return -1;
    }
    
    public boolean criarConta(String titular, String numAgencia,int numConta,double saldo){
        if(saldo<0 || numConta<0){
            return false;
        }
        ArrayList<Conta> contas = Database.getInstance().getContas();
        for(Conta conta: contas){
            if(conta.getNumConta()==numConta){
                return false;
            }
        }
        Database.getInstance().addToContas(new Conta(numAgencia,titular,numConta,saldo));
        return true;
    }
    
    
}
