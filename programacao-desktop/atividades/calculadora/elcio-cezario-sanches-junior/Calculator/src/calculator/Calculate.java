/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author ecaanchesjr
 */
public class Calculate {
    private String operation;
    private double value1, value2;
    private boolean value1Set;

    public double calculate() {
        double result=0;
        switch(operation) {
            case "+":
                result = (value1 + value2);
                break;
            case "-":
                result = (value1 - value2);
                break;
            case "/":
                result = (value1 / value2);
                break;
            case "x":
                result = (value1 * value2);
                break;
        }
        return(result);
    }
    
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = Double.parseDouble(value1);
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = Double.parseDouble(value2);
    }

    public boolean isValue1Set() {
        return value1Set;
    }

    public void setValue1Set(boolean value1Set) {
        this.value1Set = value1Set;
    }
    
    public void clearData(){
        value1 = value2 = 0;
        operation = "";
        value1Set = false;
    }
    
    
}
