package calculadora;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geovannemoro
 */

public class Calculo {

    public static void main(String args[])
    {
        Calculo c = new Calculo();
        System.out.println(">>>>"+c.calculadora("5/5"));
    }
    public String calculadora(String expression) {
        String result;
        List<Double> listNumbers = new ArrayList<Double>();
        List<Character> listOperators = new ArrayList<Character>();

        listNumbers = addNumbers(expression);
        listOperators = addOperators(expression);

        result = calculatesValues(listNumbers, listOperators);

        return result;

    }

    private String calculatesValues(List<Double> listNumbers, List<Character> listOperators) {
        String result = "";
        double total = 0.0;
        int j=0;
        for (int i = 0; i < listNumbers.size()-1; i++) {

            if ( total==0.0) {
                double number1 = listNumbers.get(i).doubleValue();
                double number2 = listNumbers.get(i + 1).doubleValue();
                char operator = listOperators.get(i).charValue();
                total = executarOperacao(number1, operator, number2);
            }
            else if (total>0.0) {
                
                double number2 = listNumbers.get(i).doubleValue();
                char operator = listOperators.get(j).charValue();
                total = executarOperacao(total, operator, number2);
                j++;
            }
            
            

        }

        result = ""+total;
        return result;
    }

    private double executarOperacao(double number1, char operator, double number2) {
        double result = 0.0;

        if (operator == '+') {
            result = number1 + number2;
        } else if (operator == '-') {
            result = number1 - number2;
        } else if (operator == '/') {
            result = number1 / number2;
        } else if (operator == '*') {
            result = number1 * number2;
        }
        return result;
    }

    private List<Double> addNumbers(String expression) {

        List<Double> listNumbers = new ArrayList<Double>();

        String numberInString = "";
        for (int i = 0; i < expression.length(); i++) {

            if (isOperator(expression.charAt(i))) {
                Double number = Double.valueOf(numberInString);
                listNumbers.add(number);
                numberInString = "";
            } else {
                numberInString = numberInString.concat("" + expression.charAt(i));
            }
        }
        if(!numberInString.isEmpty())
        {
                Double number = Double.valueOf(numberInString);
                listNumbers.add(number);
            
        }
        return listNumbers;
    }

    private List<Character> addOperators(String expression) {

        List<Character> listOperators = new ArrayList<Character>();


        for (int i = 0; i < expression.length(); i++) {

            if (isOperator(expression.charAt(i))) {
                listOperators.add(new Character(expression.charAt(i)));
            }
        }

        return listOperators;
    }

    private boolean isOperator(char caracter) {
        boolean isOperator = false;
        if (caracter == '-' || caracter == '+' || caracter == '/' || caracter == '*') {
            isOperator = true;
        }
        return isOperator;
    }
} 