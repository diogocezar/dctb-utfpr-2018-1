/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;

/**
 *
 * @author nicholas
 */
public class GerenciadorDeConta {
    
    ArrayList<Account> Accounts = new ArrayList<>();

    public String listarContas() {
        String accountsString = "";
        for(int i=0; i<Accounts.size(); i++){
            accountsString += "Holder: " + Accounts.get(i).getHoldername() + "   Account number: " + Accounts.get(i).getAccountnumber();
        }
        
        return accountsString;
    }

    public void removerConta(int numeroDaConta) {
        for(int i=0; i<Accounts.size(); i++){
            if(numeroDaConta == Accounts.get(i).getAccountnumber()){
                Accounts.remove(i);
            }
        }
    }

    public void atualizarNomeDoTitular(int numeroDaConta, String novoNomeDoTitular) {
        for(int i=0; i<Accounts.size(); i++){
            if(numeroDaConta == Accounts.get(i).getAccountnumber()){
                Accounts.get(i).setHoldername(novoNomeDoTitular);
            }
        }
    }

    public String pesquisarAgencia(int numeroDaConta) {
        for(int i=0; i<Accounts.size(); i++){
            if(numeroDaConta == Accounts.get(i).getAccountnumber()){
                return Accounts.get(i).getAgency();
            }
        }
        return "Não encontrou a conta.";
    }

    public double pesquisarSaldo(int numeroDaConta) {
        for(int i=0; i<Accounts.size(); i++){
            if(numeroDaConta == Accounts.get(i).getAccountnumber()){
                return Accounts.get(i).getBalance();
            }
        }  
        return -1;
    }

    public void criarConta(String titular, String agencia, int numero, double saldo) {
        Account account = new Account();
        
        account.setAccountnumber(numero);
        account.setAgency(agencia);
        account.setBalance(saldo);
        account.setHoldername(titular);
        
        Accounts.add(account);
    }
    
}
