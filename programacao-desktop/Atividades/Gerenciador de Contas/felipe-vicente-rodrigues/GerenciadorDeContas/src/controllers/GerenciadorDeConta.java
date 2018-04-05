/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class GerenciadorDeConta {

    Contas contas = new Contas();
    ArrayList<Contas> lista = new ArrayList<>();

    public String listarContas() {
        /*
        for (Contas conts : lista) {           
            return (" Agencia: " + conts.getAgencia()
                    + "\n Conta: " + conts.getNumero()
                    + "\n Titular: " + conts.getTitular()
                    + "\n Saldo: " + conts.getSaldo());

        }
        return "--";
         */
        String listaContas = "";

        for (int i = 0; i < lista.size(); i++) {
            listaContas += ("\n\nAgencia: " + lista.get(i).getAgencia()
                    + "\n Conta: " + lista.get(i).getNumero()
                    + "\n Titular: " + lista.get(i).getTitular()
                    + "\n Saldo: " + lista.get(i).getSaldo());
        }
        return listaContas;
    }

    public void removerConta(int numeroDaConta) {

        for (Contas conts : lista) {
            if (conts.getNumero() == numeroDaConta) {
                lista.remove(conts);
                JOptionPane.showMessageDialog(null, "Conta " + conts.getNumero() + " removida com sucesso.");
            } else {

                JOptionPane.showMessageDialog(null, "Conta " + conts.getNumero() + " não encontrada.");
            }
        }
    }

    public void atualizarNomeDoTitular(int numeroDaConta, String novoNomeDoTitular) {

        for (Contas conts : lista) {
            if (conts.getNumero() == numeroDaConta) {
                conts.setTitular(novoNomeDoTitular);
               // lista.add(conts);
                JOptionPane.showMessageDialog(null, "Titular da conta " + conts.getNumero() + " "
                        + "alterado com sucesso.");
            } else {

                JOptionPane.showMessageDialog(null, "Conta " + conts.getNumero() + " não encontrada.");
            }
        }

    }

    public String pesquisarAgencia(int numeroDaConta) {

        for (Contas conts : lista) {
            if (conts.getNumero() == numeroDaConta) {
                return conts.getAgencia();
            }
        }
        return "Conta " + numeroDaConta + "não encontrada.";
    }

    public double pesquisarSaldo(int numeroDaConta) {

        for (Contas conts : lista) {
            if (conts.getNumero() == numeroDaConta) {
                return conts.getSaldo();
            } else {
                JOptionPane.showMessageDialog(null, "Conta " + numeroDaConta
                        + " não encontrada");
            }
        }
        return 0;

    }

    public void criarConta(String titular, String agencia, int numero, double saldo) {

        Contas c = new Contas();
                        
        c.setAgencia(agencia);
        c.setNumero(numero);
        c.setTitular(titular);
        c.setSaldo(saldo);

        lista.add(c);

    }

}
