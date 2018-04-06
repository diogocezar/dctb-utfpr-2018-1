package controladores;

import entidades.BancoDeDados;
import entidades.Conta;
import java.util.Map;

public class GerenciadorDeConta {

    public String listarContas() {
        String retorno = "";
        for (Map.Entry<String, Conta> conta : BancoDeDados.listContas().entrySet()) {
            retorno += "Titular: " + conta.getValue().getNomeTitular() + "\n";
            retorno += "Agencia: " + conta.getValue().getAgencia() + "\n";
            retorno += "Conta: " + conta.getValue().getConta() + "\n\n---------------------------------\n\n";
        }
        return retorno;
    }

    public boolean removerConta(String numeroDaConta) {
        return BancoDeDados.deletarConta(numeroDaConta);
    }

    public boolean atualizarNomeDoTitular(String numeroDaConta, String nome) {
        Conta conta = BancoDeDados.getConta(numeroDaConta);
        if (conta != null) {
            conta.setNomeTitular(nome);
            return true;
        }
        return false;
    }

    public String pesquisarAgencia(String numeroDaConta) {
        Conta conta = BancoDeDados.getConta(numeroDaConta);
        if (conta != null) {
            return conta.getAgencia();
        }
        return null;
    }

    public double pesquisarSaldo(String numeroDaConta) {
        Conta conta = BancoDeDados.getConta(numeroDaConta);
        if (conta != null) {
            return conta.getSaldo();
        }
        return -1;
    }

    public boolean criarConta(String nome, String agencia, String conta, double saldo) {
        if (saldo < 0 || conta.isEmpty() || nome.isEmpty() || agencia.isEmpty()) {
            return false;
        }
        if(BancoDeDados.getConta(conta) == null){
            BancoDeDados.addConta(new Conta(agencia, conta, nome, saldo));
            return true;
        }else{
            return false;
        }
    }
}
