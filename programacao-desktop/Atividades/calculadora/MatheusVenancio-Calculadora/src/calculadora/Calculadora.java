package calculadora;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    public static void main(String args[]) {
        Calculadora C = new Calculadora();
        System.out.println(">>>>" + C.calculadora("5/5"));
    }

    public String calculadora(String expressao) {
        String resultado;
        List<Double> LNumeros = new ArrayList<Double>();
        List<Character> LOperacao = new ArrayList<Character>();

        LNumeros = conseguirNumeros(expressao);
        LOperacao = ConseguirOperadores(expressao);

        resultado = calcularValor(LNumeros, LOperacao);

        return resultado;

    }

    private String calcularValor(List<Double> LNumeros, List<Character> LOperacao) {
        String resultado = "";
        double total = 0.0;
        int j = 0;
        for (int i = 0; i < LNumeros.size() - 1; i++) {

            if (total == 0.0) {
                double numero1 = LNumeros.get(i).doubleValue();
                double numero2 = LNumeros.get(i + 1).doubleValue();
                char operador = LOperacao.get(i).charValue();
                total = executarOperacao(numero1, operador, numero2);
            } else if (total > 0.0) {

                double numero2 = LNumeros.get(i).doubleValue();
                char operador = LOperacao.get(j).charValue();
                total = executarOperacao(total, operador, numero2);
                j++;
            }

        }

        resultado = "" + total;
        return resultado;
    }

    private double executarOperacao(double numero1, char operador, double numero2) {
        double resultado = 0.0;

        if (operador == '+') {
            resultado = numero1 + numero2;
        } else if (operador == '-') {
            resultado = numero1 - numero2;
        } else if (operador == '/') {
            resultado = numero1 / numero2;
        } else if (operador == '*') {
            resultado = numero1 * numero2;
        }
        return resultado;
    }

    private List<Double> conseguirNumeros(String expressao) {

        List<Double> LNumeros = new ArrayList<Double>();

        String N = "";
        for (int i = 0; i < expressao.length(); i++) {

            if (isOperador(expressao.charAt(i))) {
                Double numero = Double.valueOf(N);
                LNumeros.add(numero);
                N = "";
            } else {
                N = N.concat("" + expressao.charAt(i));
            }
        }
        if (!N.isEmpty()) {
            Double numero = Double.valueOf(N);
            LNumeros.add(numero);

        }
        return LNumeros;
    }

    private List<Character> ConseguirOperadores(String expressao) {

        List<Character> listaOperadores = new ArrayList<Character>();

        for (int i = 0; i < expressao.length(); i++) {

            if (isOperador(expressao.charAt(i))) {
                listaOperadores.add(new Character(expressao.charAt(i)));
            }
        }

        return listaOperadores;
    }

    private boolean isOperador(char caracter) {
        boolean isOperador = false;
        if (caracter == '-' || caracter == '+' || caracter == '/' || caracter == '*') {
            isOperador = true;
        }
        return isOperador;
    }
}
