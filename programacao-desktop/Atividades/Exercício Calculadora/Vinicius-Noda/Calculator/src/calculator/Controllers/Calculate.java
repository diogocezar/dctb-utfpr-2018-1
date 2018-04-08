/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Controllers;

/**
 *
 * @author noda
 */
public class Calculate {

    private double num1, num2;
    private String op;
    private boolean num1Set;
    private boolean percentageOp;

    public boolean isPercentageOp() {
        return percentageOp;
    }

    public void setPercentageOp(boolean percentageOp) {
        this.percentageOp = percentageOp;
    }

    public boolean isNum1Set() {
        return num1Set;
    }

    public void setNum1Set(boolean num1Set) {
        this.num1Set = num1Set;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
        this.num1Set = true;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void clearData() {
        num1 = num2 = 0;
        op = "";
        num1Set = false;
        percentageOp = false;
    }

    public double calculate() {
        double res = 0;

        switch (op) {
            case "+":
                res = percentageOp ? (num1 + (num1 * (num2 / 100))) : (num1 + num2);
                break;
            case "-":
                res = percentageOp ? (num1 - (num1 * (num2 / 100))) : (num1 - num2);
                break;
            case "/":
                res = percentageOp ? (num1 / (num2 / 100)) : (num1 / num2);
                break;
            case "*":
                res = percentageOp ? (num1 * (num2 / 100)) : (num1 * num2);
                break;
        }

        clearData();

        return res;
    }
}
