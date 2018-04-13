/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author andre
 */
public class Calculator {
    
    public double sum(double a,double b){
        if(a > 0)
            return a + b;
        else
            return b;
    }
    
    public double sub(double a,double b){
        if(a > 0)
            return b - a;
        else
            return b;
    }
    
    public double mul(double a,double b){
        if(a > 0)
            return b * a;
        else
            return b;
    }
    
    public double div(double a,double b){
        if(a > 0)
            return b / a;
        else
            return b;
    }
    
    public double percentage(double a){
        return a/100;
    }
    
    public double equal(double a, double b,int operation){
        switch(operation){
            case 1:
                return a+b;
            case 2:
                return a-b;
            case 3:
                return a*b;
            case 4:
                return a/b;
            case 5:
                return a/100;
            default:
                break;
        }
        return a;
    }
    
}
