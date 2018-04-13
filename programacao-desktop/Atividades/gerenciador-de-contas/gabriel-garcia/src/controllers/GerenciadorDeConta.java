package controllers;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GerenciadorDeConta {

    private ArrayList<Conta> accounts = new ArrayList<>();

    public String listarContas(){
        String acc = "";
        if(accounts.size() > 0){
            for(int i = 0; i <= accounts.size() - 1; i++){
                acc = acc + "Titular: " + accounts.get(i).getTitular() + "  Numero: " + accounts.get(i).getNumero()
                        + "  Agencia: " + accounts.get(i).getAgencia() + "  Saldo: " + accounts.get(i).getSaldo() + "\n";
            }
            return acc;
        } else {
            return "Não há contas cadastradas";
        }
    }

    public Integer searchAccount(int numConta) {
        for (int i = 0; i <= accounts.size() - 1; i++) {
            if
                    (accounts.get(i).getNumero() == numConta) {
                return i;
            }
        }
        return null;
    }

    public boolean validateAccount(int numConta) {
        if(accounts.isEmpty()){
            return true;
        }
        for (int i = 0; i <= accounts.size() - 1; i++) {
            if(accounts.get(i).getNumero() == numConta){
                return false;
            }
        }
        return true;
    }

    public void criarConta(String titular, String agencia, int numero, double saldo) {
        Conta aux = new Conta();

        aux.setTitular(titular);
        aux.setAgencia(agencia);
        aux.setNumero(numero);
        aux.setSaldo(saldo);

        if (validateAccount(numero)) {
            try {
                accounts.add(aux);
                JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
            } catch (Exception e) {
            }
        }
        System.out.println(accounts.toString());
    }

    public void removerConta(int numeroDaConta) {
        Integer id = searchAccount(numeroDaConta);
        if(id != null){
            accounts.remove(id);
            JOptionPane.showMessageDialog(null, "Conta removida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public void atualizarNomeDoTitular(int numeroDaConta, String novoNomeDoTitular) {
        Integer id = searchAccount(numeroDaConta);
        if(id != null){
            accounts.get(id).setTitular(novoNomeDoTitular);
            JOptionPane.showMessageDialog(null, "Nome do titular atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public String pesquisarAgencia(int numeroDaConta) {
        Integer id = searchAccount(numeroDaConta);
        if(id != null){
            return accounts.get(id).getAgencia();
        } else {
            return null;
        }
    }

    public double pesquisarSaldo(int numeroDaConta) {
        Integer id = searchAccount(numeroDaConta);
        if(id != null){
            return accounts.get(id).getSaldo();
        } else {
            return 0;
        }
    }

}
