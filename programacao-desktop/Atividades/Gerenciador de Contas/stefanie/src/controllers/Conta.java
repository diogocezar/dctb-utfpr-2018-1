package controllers;

public class Conta {

    
    private int number;
    private String agency, holder;
    private double balance;

    public Conta(String holder, String agency, int number, double balance) {
        this.number = number;
        this.agency = agency;
        this.holder = holder;
        this.balance = balance;
    }


    public double getNumber(){
        return this.number;
    }

    public String getAgency(){
        return this.agency;
    }

    public String getHolder(){
        return this.holder;
    }

    public void setHolder(String holder){ 
        this.holder = holder;
    }

    public double getBalance(){
        return this.balance;
    }

    public String toString(){
        String aux = "";
        aux = "Número: " + this.number;
        aux += "\nTitular: " + this.holder;
        aux += "\nAgência: " + this.agency;
        aux += "\nSaldo: $" + this.balance;

        return aux;
    }

}