
package model;

/**
 *
 * @author igorv
 */
public class Account {
    private String name, agency;
    private int accNumber;
    private double balance;

    public Account(String name, String agency, int accNumber, double balance){
        this.name = name;
        this.agency = agency;
        this.accNumber = accNumber;
        this.balance = balance;
    }
    
    public String getName(){
        return name;
    }

    public String getAgency(){
        return agency;
    }

    public int getAccNumber(){
        return accNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAgency(String agency){
        this.agency = agency;
    }

    public void setNum(int accNumbrt){
        this.accNumber = accNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
 
}
