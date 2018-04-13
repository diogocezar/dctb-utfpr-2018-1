/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author nicholas
 */
public class Account {

    private String agency;
    private String Holdername;
    private int Accountnumber;
    private double balance;
    
    /**
     * @return the agency
     */
    public String getAgency() {
        return agency;
    }

    /**
     * @param agency the agency to set
     */
    public void setAgency(String agency) {
        this.agency = agency;
    }

    /**
     * @return the Holdername
     */
    public String getHoldername() {
        return Holdername;
    }

    /**
     * @param Holdername the Holdername to set
     */
    public void setHoldername(String Holdername) {
        this.Holdername = Holdername;
    }

    /**
     * @return the Accountnumber
     */
    public int getAccountnumber() {
        return Accountnumber;
    }

    /**
     * @param Accountnumber the Accountnumber to set
     */
    public void setAccountnumber(int Accountnumber) {
        this.Accountnumber = Accountnumber;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
