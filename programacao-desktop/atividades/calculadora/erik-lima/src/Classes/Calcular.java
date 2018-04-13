/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Erik Lima
 */
public class Calcular {
    public double calcular(double num1, double num2, char operacao){
        double resultado = 0;
        if((num1!= 0)&& (num2!= 0)){
        if(operacao == '+'){
            Soma soma = new Soma();
           resultado= soma.som(num1, num2);   
            
        }if(operacao == '-'){
            Subtracao subtracao = new Subtracao();
            resultado = subtracao.sub(num1, num2); 
            
        }if(operacao == '*'){
            Multiplicacao multiplicacao = new Multiplicacao();
            resultado = multiplicacao.multi(num1, num2);
            
        }if(operacao == '/'){
            Divisao divisao = new Divisao();
            resultado =divisao.div(num1, num2);
            
        }
        }
       return resultado;
        
    }
    }
    

