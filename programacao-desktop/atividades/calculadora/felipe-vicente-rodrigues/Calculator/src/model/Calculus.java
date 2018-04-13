/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author felipe
 */
public class Calculus {

    float result = 0;
    String sinal = null;

    public Float calculate(String signal, Float number1, Float number2) {

        if (signal.equals("+")) {
            return sum(number1, number2);
        } else if (signal.equals("-")) {
            return subtraction(number1, number2);
        } else if (signal.equals("/")) {
            return division(number1, number2);
        } else if (signal.equals("*")) {
            return multiplication(number1, number2);
        }
        return result;

    }

    public float sum(Float number1, Float number2) {
        return number1 + number2;
    }

    public float subtraction(Float number1, Float number2) {
        return number1 - number2;
    }

    public float division(Float number1, Float number2) {
        return number1 / number2;
    }

    public float multiplication(Float number1, Float number2) {
        return number1 * number2;
    }

    public float percentage(Float number1, Float number2) {
        return result;
    }

}
