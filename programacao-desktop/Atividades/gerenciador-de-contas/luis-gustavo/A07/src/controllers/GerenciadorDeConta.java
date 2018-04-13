/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import model.Conta;

/**
 *
 * @author gustavomiara
 */
public class GerenciadorDeConta {

    ArrayList<Conta> contas = new ArrayList();

    public String listarContas() {
        ArrayList<String> list = new ArrayList();
        for (Iterator iterator = contas.iterator(); iterator.hasNext();) {
            Conta c = (Conta) iterator.next();
            list.add(c.toString());
        }
        
        return list.toString();
    }

    public void removerConta(int numeroDaConta) {
        Conta c = pesquisarConta(numeroDaConta);
        if (c != null) {
            contas.remove(c);
        } else {
        }
        contas.remove(c);
    }

    public void atualizarNomeDoTitular(int numeroDaConta, String novoNomeDoTitular) {
        Conta c = pesquisarConta(numeroDaConta);
        if (c != null) {
            c.setTitular(novoNomeDoTitular);
        } else {
        }

    }

    public String pesquisarAgencia(int numeroDaConta) {
        Conta c = pesquisarConta(numeroDaConta);
        if (c != null) {
            return c.getAgencia();
        } else {
            return "Conta não encontrada!";
        }
    }

    public double pesquisarSaldo(int numeroDaConta) {
        Conta c = pesquisarConta(numeroDaConta);
        if (c != null) {
            return c.getSaldo();
        } else {
            return -1;
        }
    }

    public void criarConta(String titular, String agencia, int numero, double saldo) {
        Conta ct = new Conta(titular, agencia, numero, saldo);
        contas.add(ct);
    }

    public Conta pesquisarConta(int numeroDaConta) {
        for (Iterator iterator = contas.iterator(); iterator.hasNext();) {
            Conta c = (Conta) iterator.next();
            if (numeroDaConta == c.getNumero()) {
                return c;
            }
        }
        return null;
    }

}
