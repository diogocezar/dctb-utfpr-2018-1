/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.JOptionPane;

/**
 *
 * @author kamimuraf
 */
public class Central {
    
    
    private double n1, n2;
    private int operation; // 1:sum 2:subtraction 3:mult 4:div

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
    
    
    
    public double central(){
    
        switch(operation){
            case 1: //sum
                return sum(n1, n2);
               
            case 2: //subtraction
                return subtraction(n1, n2);
               
            case 3: //multiplication
                return multiplication(n1, n2);
                
            case 4: //division
                    return division(n1,n2);
            default: 
                return n1;
        
        }
    
    }
    public double sum (double n1, double n2){
        return n1 + n2;
    }
    
    public double subtraction (double n1, double n2){
        return n1 - n2;
    }
    
    public double multiplication (double n1, double n2){
        return n1*n2;
    }
    
    public double division (double n1, double n2){
        try{
            if( n2 == 0.0 ) 
            {
                throw new ArithmeticException();
            }
            return n1/n2;
        }   catch(ArithmeticException ex){
            JOptionPane.showMessageDialog(null,"Error: trying to divide by 0(zero).");
        }
        return 0;
    }
    
    
   public boolean checkOperator(String ex){
       for (int i = 0; i < ex.length(); i++){
        if((ex.charAt(i) == '+' || ex.charAt(i) == '-' || ex.charAt(i) == '*' || ex.charAt(i) == '/' )){
            return true;
        }
       }
       return false;
   }
    
}
