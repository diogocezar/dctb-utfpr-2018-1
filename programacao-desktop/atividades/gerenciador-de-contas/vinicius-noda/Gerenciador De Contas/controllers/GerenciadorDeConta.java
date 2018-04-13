package controllers;

import exceptions.AccountNotFound;
import java.util.ArrayList;
import exceptions.EmptyString;
import exceptions.NegativeNumber;

public class GerenciadorDeConta{

    private class Account{
        private int number;
        private String agency, holder;
        private double balance;

        public Account(int number, String agency, String holder, double balance) throws EmptyString, NegativeNumber{
            setNumber(number);
            setAgency(agency);
            setHolder(holder);
            setBalance(balance);
        }

        public int getNumber(){
            return number;
        }

        public String getAgency(){
            return agency;
        }

        public String getHolder(){
            return holder;
        }

        public double getBalance(){
            return balance;
        }

        public void setNumber(int number) throws NegativeNumber{
            if(number<0){
                throw new NegativeNumber();
            }
            this.number = number;
        }

        public void setAgency(String agency) throws EmptyString{
            if(agency.isEmpty()){
                throw new EmptyString("agency");
            }
            this.agency = agency;
        }

        public void setHolder(String holder) throws EmptyString{
            if(holder.isEmpty()){
                throw new EmptyString("holder");
            }
            this.holder = holder;
        }

        public void setBalance(double balance){
            this.balance = balance;
        }
    }

    private ArrayList<Account> accounts = new ArrayList<>();
    
    public String listarContas(){
        String response = "";
        if(accounts.isEmpty()){
            return "no registered account";
        }
        for(Account a : accounts){
            response += "Account number: "+a.getNumber()+"\n";
            response += "\tAgency: "+a.getAgency()+"\n";
            response += "\tHolder: "+a.getHolder()+"\n";
            response += "\tBalance: "+a.getBalance()+"\n";
            response += "\n";
        }
        return response;
    }
    
    public void removerConta(int number) throws AccountNotFound{
        accounts.remove(searchAccount(number));
    }
    
    public void atualizarNomeDoTitular(int number, String holder) throws AccountNotFound, EmptyString{
        searchAccount(number).setHolder(holder);
    }

    public String pesquisarAgencia(int number) throws AccountNotFound{
        return(searchAccount(number).getAgency());
    }
    
    public double pesquisarSaldo(int number) throws AccountNotFound{
        return(searchAccount(number).getBalance());
    }
    
    public void criarConta(String holder, String agency, int number, double balance) throws EmptyString, NegativeNumber{
        accounts.add(new Account(number, agency, holder, balance));
    }
    
    private Account searchAccount(int number) throws AccountNotFound{
        for(Account a : accounts){
            if(a.getNumber() == number){
                return a;
            }
        }
        throw new AccountNotFound();
    }
}