/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Interface.Calc;

/**
 *
 * @author gustavomiara
 */
public class Calculadora implements Calc{

    @Override
    public double convertDouble(String x) {
        x = x.replace(",",".");
        return Double.parseDouble(x);         
    }

    @Override
    public double soma(double a, double b) {
        return a + b;
    }

    @Override
    public double subtracao(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplicacao(double a, double b) {
        return a * b;
    }

    @Override
    public double divisao(double a, double b) {
        return a / b;
    }

    @Override
    public double igual(String operacao, double a, double b) {
        switch(operacao){
            case "adicao":
                return soma(a, b);
            case "subtracao":
                return subtracao(a, b);
            case "multiplicacao":
                return multiplicacao(a, b);
            case "divisao":
                return divisao(a, b);
            default:
                return -1;
        }        
    }

    @Override
    public String numZero() {
        return "0";
    }

    @Override
    public String numUm() {
        return "1";
    }

    @Override
    public String numDois() {
        return "2";
    }

    @Override
    public String numTres() {
        return "3";
    }

    @Override
    public String numQuatro() {
        return "4";
    }

    @Override
    public String numCinco() {
        return "5";
    }

    @Override
    public String numSeis() {
        return "6";
    }

    @Override
    public String numSete() {
        return "7";
    }

    @Override
    public String numOito() {
        return "8";
    }

    @Override
    public String numNove() {
        return "9";
    }

    @Override
    public String virgula() {
        return ",";
    }

    @Override
    public String limpar() {
        return "";
    }

    
}
