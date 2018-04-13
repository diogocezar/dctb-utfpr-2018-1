/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles.gerencia;

import controles.Conta;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class GerenciadorDeConta {
    ArrayList<Conta> contas = new ArrayList<>();

    public String listarContas() {
        String aux = "";
        for(Conta conta : contas){
            aux += conta.toString()+ "\n";
        }
        return aux;
    }

    public void removerConta(int numeroDaConta) throws Exception{
        for(Conta conta : contas)
            if(numeroDaConta == conta.getId())
                contas.remove(conta);
        throw new Exception("Conta não encontrada");
    }

    public void atualizarNomeDoTitular(int numeroDaConta, String novoNomeDoTitular) {
        for(Conta conta : contas)
            if(numeroDaConta == conta.getId())
                conta.setTitular(novoNomeDoTitular);
    }

    public String pesquisarAgencia(int numeroDaConta) {
        for(Conta conta : contas)
            if(numeroDaConta == conta.getId())
                return conta.getAgencia();
        return null;
    }

    public double pesquisarSaldo(int numeroDaConta) {
        for(Conta conta : contas)
                if(numeroDaConta == conta.getId())
                    return conta.getSaldo();
        return 0;
    }

    public void criarConta(String titular, String agencia, int numero, double saldo) {
        contas.add(new Conta(numero,saldo,agencia,titular));
    }
    
    
}
