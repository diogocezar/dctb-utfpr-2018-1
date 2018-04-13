package entidades;

public class Conta {
    
    private String agencia;
    private String conta;
    private String nomeTitular;
    private double saldo;

    public Conta(String agencia, String conta, String nomeTitular, double saldo) {
        this.agencia = agencia;
        this.conta = conta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }
    

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
   
    
}
