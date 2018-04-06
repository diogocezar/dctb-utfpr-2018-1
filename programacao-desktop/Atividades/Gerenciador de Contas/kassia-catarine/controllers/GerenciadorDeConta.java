/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.Conta;

/**
 *
 * @author kassia
 */
public class GerenciadorDeConta {
    
    private ArrayList<Conta> contas;

    public GerenciadorDeConta() {
        this.contas = new ArrayList<>();
    }
    
    public void criarConta(String titular, String agencia, int numero, double saldo){
        Conta conta = new Conta(titular, agencia, numero, saldo);
        this.contas.add(conta);
    }
    
    public double pesquisarSaldo(int numeroDaConta) throws Exception {
        Conta c = pesquisarContaPorNumero(numeroDaConta);
        return c.getSaldo();
    }

    public String pesquisarAgencia(int numeroDaConta) throws Exception {
        Conta c = pesquisarContaPorNumero(numeroDaConta);
        return c.getAgencia();
    }

    public Conta pesquisarContaPorNumero(int numeroDaConta) throws Exception {
        for (Conta c : contas) {
            if (c.getNumero() == numeroDaConta) {
                return c;
            }
        }
        throw new Exception("Conta não encontrada.");
    }

    public void atualizarNomeDoTitular(int numeroDaConta, String novoNomeDoTitular) throws Exception {
        Conta c = pesquisarContaPorNumero(numeroDaConta);

        if (c != null) {
            c.setTitular(novoNomeDoTitular);
        }
    }

    public void removerConta(int numeroDaConta) throws Exception {
        Conta c = pesquisarContaPorNumero(numeroDaConta);

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero() == c.getNumero()) {
                contas.remove(i);
            }
        }
    }

    public String listarContas() {
        String printLista = "";

        if (contas.size() >= 1) {
            for (Conta c : contas) {
                printLista += 
                "\n\nNumero da Conta: " + c.getNumero() +
                "\nNumero da Agência: " + c.getAgencia() +
                "\nTitular: " + c.getTitular() +
                "\nSaldo: " + c.getSaldo() + "\n\n";
            }
    
            return printLista;
        }
        return "Nenhuma Conta Cadastrada.";
    }

}
