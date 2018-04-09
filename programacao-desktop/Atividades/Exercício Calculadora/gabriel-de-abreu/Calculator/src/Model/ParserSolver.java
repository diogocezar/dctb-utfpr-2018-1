/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ParserSolver {

    String expression;
    ArrayList<String> executionPile;

    public ParserSolver(String expression) {
        this.expression = expression;
        executionPile = new ArrayList<>();
    }

    private double executeExpression() throws Exception {
        //Execute all X first
        int i = 0;
        int size = executionPile.size();
        while (i < size) {
            if (executionPile.get(i).equals("x")) {
                try {
                    double value = Double.parseDouble(executionPile.get(i - 1))
                            * Double.parseDouble(executionPile.get(i + 1));
                    executionPile.set(i, Double.toString(value));
                } catch (Exception e) {
                    throw new InvalidExpressionException("Entrada de valor inválida");
                }
                executionPile.remove(i - 1);
                executionPile.remove(i);
                size = executionPile.size();
                i = 0;
            }
            i++;
        }
        //Execute all /
        size = executionPile.size();
        i = 0;
        while (i < size) {
            if (executionPile.get(i).equals("/")) {
                try {
                    double value = Double.parseDouble(executionPile.get(i - 1))
                            / Double.parseDouble(executionPile.get(i + 1));
                    executionPile.set(i, Double.toString(value));
                } catch (Exception e) {
                    throw new InvalidExpressionException("Entrada de valor inválida!");
                }

                executionPile.remove(i - 1);
                executionPile.remove(i);
                size = executionPile.size();
                i = 0;
            }
            i++;
        }
        //Execute all +
        size = executionPile.size();
        i = 0;
        while (i < size) {
            if (executionPile.get(i).equals("+")) {
                try {
                    double value = Double.parseDouble(executionPile.get(i - 1))
                            + Double.parseDouble(executionPile.get(i + 1));
                    executionPile.set(i, Double.toString(value));
                } catch (Exception e) {
                    throw new InvalidExpressionException("Entrada de valor inválida!");
                }

                executionPile.remove(i - 1);
                executionPile.remove(i);
                size = executionPile.size();
                i = 0;
            }
            i++;
        }
        //Execute all -
        size = executionPile.size();
        i = 0;
        while (i < size) {
            if (executionPile.get(i).equals("-")) {
                try {
                    double value = Double.parseDouble(executionPile.get(i - 1))
                            - Double.parseDouble(executionPile.get(i + 1));
                    executionPile.set(i, Double.toString(value));
                } catch (Exception e) {
                    throw new InvalidExpressionException("Entrada de valor inválida");
                }

                executionPile.remove(i - 1);
                executionPile.remove(i);
                size = executionPile.size();
                i = 0;
            }
            i++;
        }
        //printExecution();
        try{
            return Double.parseDouble(executionPile.get(0));
        }
        catch(Exception e){
            throw new InvalidExpressionException("Entrada de valor inválida");
        }
    }

    private void setExecution() throws Exception {
        try {
            char[] strChar = expression.toCharArray();
            ArrayList<Character> aux = new ArrayList<>();
            for (char c : strChar) {
                if (c != ' ') {
                    //                System.out.println(c);
                    if (checkOperations(c)) {
                        if (aux.size() > 0) {
                            executionPile.add(new String(convertArrayListToArray(aux)));
                        }
                        executionPile.add(Character.toString(c));

                        aux.clear();
                        continue;
                    }
                    aux.add(c);
                }
            }
            if (aux.size() > 0) {
                executionPile.add(new String(convertArrayListToArray(aux)));
            }
        }catch(Exception e){
            throw new InvalidExpressionException("Entrada de valor inválida!");
        }
    }

    private void printExecution() {
        System.out.println("-----Printando Execução------");
        for (String str : executionPile) {
            System.out.println(str);
        }
    }

    private void isExpressionExecutable() throws Exception {
        if (checkOperations(executionPile.get(0))) {
            throw new InvalidExpressionException("Expressão inválida!");
        }
        boolean flagDoubleExpression = false;
        boolean flagAloneExpression = false;
        for (String el : executionPile) {
            if (checkOperations(el)) {
                if (flagDoubleExpression == false) {
                    flagDoubleExpression = true;
                    flagAloneExpression = true;
                } else {
                    throw new InvalidExpressionException("Expressão inválida!");
                }
            } else {
                flagDoubleExpression = false;
                flagAloneExpression = false;
            }
        }
        if (flagAloneExpression) {
            throw new InvalidExpressionException("Expressão inválida!");
        }
    }

    private boolean checkOperations(char c) {
        char[] Ops = {'+', '-', 'x', '/'};
        for (char op : Ops) {
            if (op == c) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOperations(String c) {
        String[] Ops = {"+", "-", "x", "/"};
        for (String op : Ops) {
            if (op.equals(c)) {
                return true;
            }
        }
        return false;
    }

    private char[] convertArrayListToArray(ArrayList<Character> origin) {
        char[] strChar = new char[origin.size()];
        int it = 0;
        for (Character c : origin) {
            strChar[it] = c;
            it++;
        }
        //System.out.println(new String(strChar));
        return strChar;
    }

    public double execute() throws Exception {
        setExecution();
        isExpressionExecutable();
        return executeExpression();
    }

    public static double solve(String expression) throws Exception {
        return new ParserSolver(expression).execute();

    }
}
