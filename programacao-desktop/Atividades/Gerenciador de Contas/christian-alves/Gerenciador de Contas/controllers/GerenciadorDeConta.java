package controllers;

import models.Conta;
import java.util.ArrayList;

public class GerenciadorDeConta {

    ArrayList<Conta> contas = new ArrayList<>();

    public void criarConta(String titular, String agencia, int numero, double saldo) {
        contas.add(new Conta(numero, agencia, titular, saldo));
    }

    public Conta removerConta(int numeroDaConta) throws Exception {
        for (int i=0; i<this.contas.size(); i++) {
            if (contas.get(i).getNumero() == numeroDaConta) {
                return contas.remove(i);
            }
        }
        throw new Exception("Conta não encontrada.");
    }

    public String listarContas() {
        String aux = "";

        for (Conta conta : contas) { aux += conta + "\n"; }

        return aux;
    }
    
    private Conta buscarConta(int numeroDaConta) {
        if (contas.isEmpty())
            return null;
        
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroDaConta) {
                return conta;
            }
        }
        
        return null;
    }

    public void atualizarNomeDoTitular(int numeroDaConta, String novoNome)
            throws Exception {
        Conta conta = this.buscarConta(numeroDaConta);
        if (conta == null)
            throw new Exception("Conta não encontrada.");
        else
            conta.setTitular(novoNome);
    }
    
    public String pesquisarAgencia(int numeroDaConta) throws Exception {
        Conta conta = buscarConta(numeroDaConta);
        if (conta == null)
            throw new Exception("Conta não encontrada.");
        else
            return conta.getAgencia();
    }
    
    public double pesquisarSaldo(int numeroDaConta) throws Exception {
        Conta conta = buscarConta(numeroDaConta);
        
        if (conta == null)
            throw new Exception("Conta não encontrada.");
        else
            return conta.getSaldo();
    }
}