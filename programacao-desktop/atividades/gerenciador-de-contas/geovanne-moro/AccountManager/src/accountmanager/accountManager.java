package controllers;
import accountmanager.Account;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author geovannemoro
 */

public class accountManager{

    private ArrayList<Account> accounts = new ArrayList<>();


    public void createAccount(String name, String agency, int accNumber, double balance){
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

    public String listAccount(){
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

    public boolean removeAccount(int accountNumber) throws Exception{
        for(Account i: accounts){
            if (i.getAccNumber() == accountNumber){
                accounts.remove(i);
                JOptionPane.showMessageDialog(null, "Conta removida com sucesso!");
                return true;
            }
        }
        throw new Exception("Conta nao existe!");
    }

    public boolean updateNameHolder(int accountNumber, String name) throws Exception{
        for(Account i : accounts){
            if(i.getAccNumber() == accountNumber){
                i.setName(name);
                JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso!");
                return true;
            }
        }
        throw new Exception("Conta nao existe!");
    }

    public String searchAgency(int accountNumber) throws Exception {
        for(Account i : accounts){
            if(i.getAccNumber() == accountNumber){
                return i.getAgency();
            }
        }
        throw new Exception("Conta nao existe!");
    }

    public double searchBalance(int accountNumber) throws Exception{
        for(Account i : accounts){
            if(i.getAccNumber() == accountNumber){
                return i.getBalance();
            }
        }
        throw new Exception("Conta nao existe!");
    }
    
}