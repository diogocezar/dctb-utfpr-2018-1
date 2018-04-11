/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodCalculadora;
import java.util.ArrayList;
/**
 *
 * @author Felipe Bueno de Paula
 */
public class Calculadora {
    
    public String calcular(String expressao){
        String total = "";
        ArrayList<Double> numeros = new ArrayList<Double>();
        ArrayList<Character> operadores = new ArrayList<Character>();
        double resultado;
        numeros = getNumeros(expressao);
        operadores = getOperadores(expressao);
        resultado = calcular(numeros, operadores);
        return total = ""+resultado;
    }
    
    public ArrayList<Double> getNumeros(String expressao){
        ArrayList<Double> num = new ArrayList<Double>();
        String numEmString = "";
        int j = 0, flag = 0;
        for(int i=0; i<expressao.length(); i++){
            if(eOperador(expressao.charAt(i))){
                numEmString = expressao.substring(j, i);
                j = i;
                double numero = Double.valueOf(numEmString);
                num.add(numero);
                flag++;
            }
            if(flag!=0){
                numEmString = expressao.substring(j+1, expressao.length());
                double numero = Double.valueOf(numEmString);
                num.add(numero);
            }
        }
        return num;
    }
    
    public ArrayList<Character> getOperadores(String expressao){
        ArrayList<Character> operadores = new ArrayList<Character>();
        for(int i=0; i<expressao.length(); i++){
            if(eOperador(expressao.charAt(i))){
                operadores.add(expressao.charAt(i));
            }
        }
        return operadores;
    }
    
    public double calcular(ArrayList<Double> numeros, ArrayList<Character> operadores){
        double resultado = 0.0;
        for(int i=0; i<numeros.size()-1; i++){
            if(resultado == 0.0){
                double num1 = numeros.get(i);
                double num2 = numeros.get(i+1);
                char operador = operadores.get(i);
                switch (operador) {
                    case '+':
                        resultado = num1 + num2;
                        break;
                    case '-':
                        resultado = num1 - num2;
                        break;
                    case '*':
                        if(num1==0 || num2==0){
                            resultado = 0.0;
                            return resultado;
                        }
                        resultado = num1 * num2;
                        break;
                    case '/':
                        resultado = num1 / num2;
                        break;
                    default:
                        break;
                }
            }
        }
        return resultado;
    }
    
    public boolean eOperador(char operador){
        boolean flag = false;
        if(operador == '+' || operador == '-' || operador == '*' || operador == '/')
            flag = true;
        return flag;
    }
}
