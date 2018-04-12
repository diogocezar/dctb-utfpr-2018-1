/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author gustavomiara
 */
public interface Calc {
    
    public final String operacao = null;
    
    public double convertDouble(String x);
    public double soma(double a, double b);
    public double subtracao(double a, double b);
    public double multiplicacao(double a, double b);
    public double divisao(double a, double b);
    public String virgula();
    public double igual(String operacao, double a, double b);
    public String numZero();
    public String numUm();
    public String numDois();
    public String numTres();
    public String numQuatro();
    public String numCinco();
    public String numSeis();
    public String numSete();
    public String numOito();
    public String numNove();
    public String limpar();
    
    
    
    
}
