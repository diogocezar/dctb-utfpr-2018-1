/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorMethods;

/**
 *
 * @author vinicius
 */
public class calcMethods {
    public float sum(float a, float b){
        return a+b;
    }
    
    public float sub(float a, float b){
        return a-b;
    }
    
    public float mult(float a, float b){
        return a*b;
    }
    
    public float div(float a, float b){
        if (b!=0) return a/b;
        else return a;
    }
    
    public float equal(float a, float b, char operator){
        switch (operator) {
            case '+':
                return sum(a,b);
            case '-':
                return sub(a,b);
            case '*':
                return mult(a,b);
            case '/':
                return div(a,b);
            default:
                break;
        }
        return -1;
    }
        
}
