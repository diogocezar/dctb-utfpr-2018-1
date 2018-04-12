/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorFunctions;

/**
 *
 * @author nicholas
 */
public class Functions {
    
    public double sum(double a, double b){
        if(a > 0)
            return a + b;
        else
            return  b;
    }
    
    public double sub(double a, double b){
        if(a > 0)
            return b - a;
        else
            return  b;
    }
    
    public double div(double a, double b){
        if(a > 0)
            return b / a;
        else
            return  b;
    }
    
    public double mult(double a, double b){
        if(a > 0)
            return b * a;
        else
            return  b;
    }
    
    public double plusminus(double a){
        return a * -1;
    }
    
    public double equal(double a, double b, char operation){
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a / b;
            case '*':
                return a * b;
            default:
                break;
        }
        return a;
    }
    
    public double read(String number){
        return Double.parseDouble(number);
    } 
}
