package Model;

import java.awt.List;
import java.util.ArrayList;

public class Calculo {
    
    public String finalCalculadora(String calculo) {
        String resultado;
        
        List<Double> listNum = new ArrayList<Double>();
        List<Character> listOp = new ArrayList<Character>();

        listNum = Numeros(calculo);
        listOp = Operacoes(calculo);

        resultado = calcularValor(listNum, listOp);

        return resultado;
    }

    public String calculo(List<Double> listNum, List<Character> listOp) {
        String resultado = "";
        double total = 0.0;
        int j=0;
        
        for (int i = 0; i < listNum.size()-1; i++) {
            if ( total==0.0) {
                double num1 = listNum.get(i).doubleValue();
                double num2 = listNum.get(i + 1).doubleValue();
                char op = listOp.get(i).charValue();
                total = execOp(num1, op, num2);
            }
            else if (total>0.0) {
                
                double numero2 = listNum.get(i).doubleValue();
                char operador = listOp.get(j).charValue();
                total = execOp(total, operador, numero2);
                j++;
            }
        }
        resultado = ""+total;
        
        return resultado;
    }

    public double execOp(double num1, char op, double num2) {
        double result = 0.0;
        
        if (op == '+') {
            result = num1 + num2;
        } 
        else if (op == '-') {
            result = num1 - num2;
        } 
        else if (op == '*') {
            result = num1 * num2;
        }
        else if (op == '/') {
            result = num1 / num2;
        } 
        else if(op == '%'){
            result = (num1 * num2) / 100;
        }
        
        return result;
    }

    public List<Double> Numeros(String num) {

        List<Double> listNum = new ArrayList<Double>();

        String numString = "";
        for (int i = 0; i < num.length(); i++) {
            if (verificarOp(num.charAt(i))) {
                Double dnum = Double.valueOf(numString);
                listNum.add(dnum);
                numString = "";
            } 
            else {
                numString = numString.concat("" + num.charAt(i));
            }
        }

        if(!numString.isEmpty()){
            Double dnum = Double.valueOf(numString);
            listNum.add(dnum);
        }
        return listNum;
    }
    
    public List<Character> Operacoes(String tipoOp) {

        List<Character> listOp = new ArrayList<Character>();

        for (int i = 0; i < tipoOp.length(); i++) {
            if (verificarOp(tipoOp.charAt(i))) {
                 listOp.add(new Character(tipoOp.charAt(i)));
            }
        }
        return listOp;
    }

    public boolean verificarOp(char operacao) {
        boolean verificarOp = false;
        
        if (operacao == '-' || operacao == '+' || operacao == '/' || operacao == '*' || operacao == '%') {
            verificarOp = true;
        }
        return verificarOp;
    }
} 

