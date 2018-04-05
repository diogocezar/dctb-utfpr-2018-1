/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.ArrayList;
/**
 *
 * @author arthu
 */
public class GerenciadorDeConta {
    private  ArrayList<Conta> database = new ArrayList();
    
    public void criarConta(String titular, String agencia, int numero, double saldo){
        Conta c1;
        database.add(c1 = new Conta(titular, agencia, numero, saldo));
    }
    
    public double pesquisarSaldo(int numeroDaConta){
        int index = 0;
        while(index < database.size()){
            if(numeroDaConta == database.get(index).getNumero())
                return database.get(index).getSaldo();
            index++;
        }return 0;
    }
    
    public String pesquisarAgencia(int numeroDaConta){
        int index = 0;
        while(index < database.size()){
            if(numeroDaConta == database.get(index).getNumero())
                return database.get(index).getAgencia();
            index++;
        }return "Nao encontrada";
    }
    
    public void atualizarNomeDoTitular(int numeroDaConta, String novoNomeDoTitular){
        int index = 0;
        while(index < database.size()){
            if(numeroDaConta == database.get(index).getNumero())
                 database.get(index).setTitular(novoNomeDoTitular);
            index++;
        }
    }
    
    public void removerConta(int numeroDaConta){
        int index = 0;
        
        while(index < database.size()){
            if(numeroDaConta == database.get(index).getNumero()){
                database.remove(index);
            }
            index++;
        }
    }
    
    public String listarContas(){
        String lista = "[-------- Contas ---------]";
        int index = 0;
        while(index < database.size()){
            lista += "\n"+database.get(index).getNumero()+"\n";
            index++;
        }
        return lista+"\n[ ------------------------- ]";
    }
}
