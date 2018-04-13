package model;

/**
 *
 * @author christian-alves
 */
public class Calculo {
    private double first, second;
    private String operation;
    
    public Calculo() {
        this.first = 0;
        this.second = 0;
        this.operation = "";
    }
    
    public void setOperation(String op) {
        this.operation = op;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }
    
    private double somar() {
        return this.first + this.second;
    }
    
    private double subtrair() {
        return this.first - this.second;
    }
    
    private double multiplicar() {
        return this.first * this.second;
    }
    
    private double dividir() throws ArithmeticException {
        return this.first / this.second;
    }
    
    public double calcular() throws ArithmeticException {
        switch(this.operation) {
            case "+":
                return somar();
            case "-":
                return subtrair();
            case "*":
                return multiplicar();
            case "/":
                return dividir();
        }
        return 0;
    }
}
