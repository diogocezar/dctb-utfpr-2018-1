/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author JOAO
 */
public class Conta {
    private String titular;
    private String agencia;
    private int numero;
    private double saldo;
    
    public Conta(){}
    
    public Conta (String titular, String agencia, int numero, double saldo){
        setTitular(titular);
        setAgencia(agencia);
        setNumero(numero);
        setSaldo(saldo);
    }
    
    public String getTitular(){
        return this.titular;
    }
    
    public String getAgencia(){
        return this.agencia;
    }
    
    public int  getNumero(){
        return this.numero;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void setTitular(String titular){
        this.titular = titular;
    }
    
    public void setAgencia(String agencia){
        this.agencia = agencia;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
}
