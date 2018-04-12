
package controllers;

import java.util.ArrayList;

public class GerenciadorDeConta {
    
    ArrayList<Conta> account = new ArrayList<>();
    
    public void criarConta(String holder, String agency, int number, double balance){
            account.add(new Conta(holder, agency, number, balance));
    }
    
    public Conta removerConta(int numberAccount) throws Exception {
        for (int i=0; i<this.account.size(); i++) {
            if (account.get(i).getNumber() == numberAccount) {
                return account.remove(i);
            }
        }
        throw new Exception("CONTA INEXISTENTE");
    }
    
     private Conta buscarConta(int numberAccount) {
        if (account.isEmpty())
            return null;
        
        for (Conta account1 : account){
            if (account1.getNumber() == numberAccount) {
                return account1;
            }
        }
        return null;
    }
     
       public void alterarNomeDoTitular(int numberAccount, String newName) throws Exception {
        Conta account = this.buscarConta(numberAccount);
        if (account == null)
            throw new Exception("CONTA INEXISTENTE");
        else
            account.setHolder(newName);
    }

    public String listarContas() {
        String aux = "";
        for (Conta account1 : account){ 
            aux = aux + account1 + "\n"; 
        }
        return aux;
    }
    
        public double pesquisarSaldo(int numberAccount) throws Exception {
        Conta account = buscarConta(numberAccount);
        
        if (account == null)
            throw new Exception("CONTA INEXISTENTE");
        else
            return account.getBalance();
    }
    
    public void atualizarNomeDoTitular(int numberAccount, String newName)
        throws Exception {
        Conta account = this.buscarConta(numberAccount);
        if (account == null)
            throw new Exception("CONTA INEXISTENTE");
        else
            account.setHolder(newName);
    }
    
    public String pesquisarAgencia(int numberAccount) throws Exception {
        Conta account = buscarConta(numberAccount);
        if (account == null)
            throw new Exception("CONTA INEXISTENTE");
        else
            return account.getAgency();
    }
        
    }
    
