package controllers;
import model.Account;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author igorv
 */

public class GerenciadorDeConta{

    private ArrayList<Account> accounts = new ArrayList<>();


    public void criarConta(String name, String agency, int accNumber, double balance){
        if(verifyAccount(accNumber)){
            Account account = new Account(name, agency, accNumber, balance);
            accounts.add(account);
            JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");
        }        
    }
    
    public boolean verifyAccount(int accountNumber){
        for(Account i: accounts){
            if(i.getAccNumber() == accountNumber){
                JOptionPane.showMessageDialog(null, "Essa conta ja existe, tente novamente!");
                return false;
            }
        }
        return true;
    }

    public String listarContas(){
        String printAccounts = "Conta nao existe!";
        
        if(accounts.size() > 0){
            printAccounts = "";
            for(Account i : accounts){
                printAccounts += "Nome: " +i.getName() +
                " | Agencia: "+i.getAgency() + " | Numero da Conta: "
                +i.getAccNumber()+ " | Saldo: "+i.getBalance() + "\n";
            }
        }
        return printAccounts;
    }

    public boolean removerConta(int accountNumber) throws Exception{
        for(Account i: accounts){
            if (i.getAccNumber() == accountNumber){
                accounts.remove(i);
                JOptionPane.showMessageDialog(null, "Conta removida com sucesso!");
                return true;
            }
        }
        throw new Exception("Conta nao existe!");
    }

    public boolean atualizarNomeDoTitular(int accountNumber, String name) throws Exception{
        for(Account i : accounts){
            if(i.getAccNumber() == accountNumber){
                i.setName(name);
                JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso!");
                return true;
            }
        }
        throw new Exception("Conta nao existe!");
    }

    public String pesquisarAgencia(int accountNumber) throws Exception {
        for(Account i : accounts){
            if(i.getAccNumber() == accountNumber){
                return i.getAgency();
            }
        }
        throw new Exception("Conta nao existe!");
    }

    public double pesquisarSaldo(int accountNumber) throws Exception{
        for(Account i : accounts){
            if(i.getAccNumber() == accountNumber){
                return i.getBalance();
            }
        }
        throw new Exception("Conta nao existe!");
    }
    
}