package controles;

public class Conta {
    private int id;
    private double saldo;
    private String agencia;
    private String titular;

    public Conta(int id, double saldo, String agencia, String titular) {
        this.id = id;
        this.saldo = saldo;
        this.agencia = agencia;
        this.titular = titular;
    }

    public double getId() {
        return this.id; 
    }

    public String getAgencia() {
        return this.agencia; 
    }

    public String getTitular() { 
        return this.titular; 
    }

    public void setTitular(String titular) { 
        this.titular = titular; 
    }

    public double getSaldo() {
        return this.saldo; 
    }
    @Override
    public String toString() {
        String aux = "";

        aux = "Id: " + this.id;
        aux += "\nTitular: " + this.titular;
        aux += "\nAgência: " + this.agencia;
        aux += "\nSaldo: $" + this.saldo;

        return aux;
    }
}