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
    
    ArrayList<Accounts> listAccounts = new ArrayList<>();

    public String listarContas() {

        String showAccounts = "";

        for (int i = 0; i < listAccounts.size(); i++) {
            showAccounts += ("\n\nAgency: " + listAccounts.get(i).getAgency()
                    + "\n Account: " + listAccounts.get(i).getNumber()
                    + "\n Holder: " + listAccounts.get(i).getHolder()
                    + "\n Balance: " + listAccounts.get(i).getBalance());
        }

        return showAccounts;
    }

    public void removerConta(int numeroDaConta) {

        for (Accounts accounts : listAccounts) {
            if (accounts.getNumber() == numeroDaConta) {
             
                listAccounts.remove(accounts);
                JOptionPane.showMessageDialog(null, "Account " + accounts.getNumber()
                        + " removed.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Account " + numeroDaConta
                + " not found.");
    }

    public void atualizarNomeDoTitular(int numeroDaConta, String novoNomeDoTitular) {

        for (Accounts accounts : listAccounts) {
            if (accounts.getNumber() == numeroDaConta) {
                accounts.setHolder(novoNomeDoTitular);
                JOptionPane.showMessageDialog(null, "Holder of account " + accounts.getNumber()
                        + " changed.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Account " + numeroDaConta
                + " not found.");
    }

    public String pesquisarAgencia(int numeroDaConta) {

        for (Accounts accounts : listAccounts) {
            if (accounts.getNumber() == numeroDaConta) {
                return accounts.getAgency();
            }
        }
        return "Account " + numeroDaConta + " not found.";
    }

    public double pesquisarSaldo(int numeroDaConta) {

        for (Accounts accounts : listAccounts) {
            if (accounts.getNumber() == numeroDaConta) {
                return accounts.getBalance();
            }
        }

        JOptionPane.showMessageDialog(null, "Account " + numeroDaConta
                + " not found.");

        System.exit(0);
        return 0;
    }

    public void criarConta(String titular, String agencia, int numero, double saldo) {

        Accounts c = new Accounts();

        c.setAgency(agencia);
        c.setNumber(numero);
        c.setHolder(titular);
        c.setBalance(saldo);

        listAccounts.add(c);

    }
}
