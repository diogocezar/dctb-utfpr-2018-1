package models;

public class Conta {
    
    private int numero;
    private String agencia, titular;
    private double saldo;

    public Conta(int numero, String agencia, String titular, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
    }

    public double getNumero() { return this.numero; }

    public String getAgencia() { return this.agencia; }

    public String getTitular() { return this.titular; }

    public void setTitular(String titular) { this.titular = titular; }

    public double getSaldo() { return this.saldo; }

    @Override
    public String toString() {
        String aux = "";

        aux = "Número: " + this.numero;
        aux += "\nTitular: " + this.titular;
        aux += "\nAgência: " + this.agencia;
        aux += "\nSaldo: $" + this.saldo;

        return aux;
    }

}