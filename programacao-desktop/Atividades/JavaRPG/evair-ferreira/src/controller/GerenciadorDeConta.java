/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author phoebo
 */
public class GerenciadorDeConta {
    
    ArrayList<Conta> contaConta = new ArrayList<>();
    
    public void criarConta(String titular, String agencia, int numero, double saldo) {
        Conta Cont1 = new Conta();
        Cont1.setAgencia(agencia);
        Cont1.setTitular(titular);
        Cont1.setNumero(numero);
        Cont1.setSaldo(saldo);
        
        contaConta.add(Cont1);
        JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");
    }
    
    public double pesquisarSaldo(int numeroConta) {
        double saldo_atual = 0;
    
        try {
            for(int i = 0; i < contaConta.size();i++){
                JOptionPane.showMessageDialog(null, "Consulta de Saldo!");
                if(contaConta.get(i).getNumero() == numeroConta){
                   saldo_atual = contaConta.get(i).getSaldo();
                }
            }
        } 
        catch (Exception e) {
        }
        return saldo_atual;
    }
    
    public String pesquisarAgencia(int numeroConta) {
          String agen = "";
          try {
            for(int i= 0; i < contaConta.size(); i++){
                if(contaConta.get(i).getNumero()== numeroConta){
                    agen = contaConta.get(i).getAgencia();
                }
                JOptionPane.showMessageDialog(null, "Agencia encontrada");
            }
        } 
          catch (Exception e) {
        }
          return agen;
    }

    public void removerConta(int numeroConta) {
        try {
            for(int i = 0; i < contaConta.size(); i++){
                if(contaConta.get(i).getNumero()== numeroConta){
                    contaConta.remove(i);
                }
                JOptionPane.showMessageDialog(null, "A conta foi removida!");
            }
        } catch (Exception e) {
        }
    }

    public void atualizarNomeDoTitular(int numeroConta, String novoNomeDoTitular) {
        try {
            for(int i = 0; i < contaConta.size(); i++){
                if(contaConta.get(i).getNumero() == numeroConta){
                    contaConta.get(i).setTitular(novoNomeDoTitular);
                    JOptionPane.showMessageDialog(null, "Nome Atualizado com sucesso!");
                }
            }
        } 
        catch (Exception e) {
        }
    }
    
    public String listarContas() {
        String aux = "";
        
        if (contaConta.size() > 0){
            for(int i = 0; i < contaConta.size(); i++){
                aux += "\n" + "\n Agencia: " + contaConta.get(i).getAgencia() +"\n Titular: "
                    + contaConta.get(i).getTitular()+ "\n Numero: " + contaConta.get(i).getNumero()
                    + "\n Saldo Conta: " + contaConta.get(i).getSaldo();
            }
            
            JOptionPane.showMessageDialog(null, "Lista de contas Cadastradas");
 
            return aux;
       }
       else { 
            return "Erro, não existe conta cadastrada!";
        }
    }         
}