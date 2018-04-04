/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ecsanchesjr
 */
public final class Account {
    String Agencia;
    String nomeTitular;
    int numConta;
    double Saldo;

    public Account(String Agencia, String nomeTitular, int numConta, double Saldo) {
        setAgencia(Agencia);
        setNomeTitular(nomeTitular);
        setNumConta(numConta);
        setSaldo(Saldo);
    }

    
    public String getAgencia() {
        return Agencia;
    }

    public void setAgencia(String Agencia) {
        this.Agencia = Agencia;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    
}
