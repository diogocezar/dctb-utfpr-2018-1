package controllers;

import java.util.ArrayList;

public class GerenciadorDeConta {

    ArrayList<Conta> listConta = new ArrayList<>();

    public void criarConta(String titular, String agencia, int numero, double saldo) {
        Conta C = new Conta();
        C.setAgencia(agencia);
        C.setTitular(titular);
        C.setNumero(numero);
        C.setSaldo(saldo);

        listConta.add(C);
    }
    public double pesquisarSaldo(int numeroDaConta) {
        double psaldo = 0;
    
        try {
            for(int i=0; i<listConta.size();i++){
                if(listConta.get(i).getNumero() == numeroDaConta){
                   psaldo = listConta.get(i).getSaldo();
            }
            }
            
        } catch (Exception e) {
        }
        return psaldo;
    }
    
    public String pesquisarAgencia(int numeroDaConta) {
          String pAgencia="";
          try {
            for(int i=0; i<listConta.size(); i++){
                if(listConta.get(i).getNumero()== numeroDaConta){
                    pAgencia = listConta.get(i).getAgencia();
                }
            }
        } catch (Exception e) {
        }
          return pAgencia;
    }

    public void removerConta(int numeroDaConta) {
        try {
            for(int i=0; i<listConta.size(); i++){
                if(listConta.get(i).getNumero()== numeroDaConta){
                    listConta.remove(i);
                }
            }
        } catch (Exception e) {
        }
    }

    public void atualizarNomeDoTitular(int numeroDaConta, String novoNomeDoTitular) {
        try {
            for(int i=0; i<listConta.size(); i++){
                if(listConta.get(i).getNumero()==numeroDaConta){
                    listConta.get(i).setTitular(novoNomeDoTitular);
                    
                }
            }
        } catch (Exception e) {
        }
    }

    public String listarContas() {
        String saida="";
        
        try {
            for(int i=0; i<listConta.size(); i++){
                saida += "\nAgencia: " + listConta.get(i).getAgencia() +"\nNome do Titular: "+ listConta.get(i).getTitular()+ "\nNumero da Agencia: " + listConta.get(i).getNumero()
                + "\nSaldo da Conta: "+listConta.get(i).getSaldo();
            }
        } catch (Exception e) {
        }
       return saida;     
    }

    

    
}
