
package controllers;

import basic.Conta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamil
 */
public class GerenciadorDeConta {

	List<Conta> listaContas;
	
	public GerenciadorDeConta(){
		listaContas = new ArrayList<>();
	}
	
	public void criaConta(String titular, String agencia, int numero , double saldo){
		Conta conta = new Conta();
		
		conta.setTitular(titular);
		conta.setAgencia(agencia);
		conta.setNumero(numero);
		conta.setSaldo(saldo);
		
		adicionaConta(conta);
	}
	
	public void adicionaConta(Conta conta){
            listaContas.add(conta);
	}
	
	public Conta procuraConta(int numConta){
            for (Conta conta : listaContas){
            	if (conta.getNumero() == numConta){
                    return conta;
		}
            }		
		return new Conta();
	}
	
	public double procuraSaldo(int numConta) throws Exception {
            Conta conta = procuraConta(numConta);
            
            if (conta.getNumero() == 0){
		throw new Exception("Conta inexistente!");
            }
            return conta.getSaldo();
	}
	
	public String procuraAgencia(int numConta) throws Exception {
            Conta conta = procuraConta(numConta);
	
            if (conta.getNumero() == 0){
			throw new Exception("Conta inexistente!");
            }
            return conta.getAgencia();
	}
	
	public void mudaTitular(int numConta, String titularEditado) throws Exception {
            Conta conta = procuraConta(numConta);
		
            if (conta.getNumero() == 0){
		throw new Exception("Conta inexistente!");
            }
            conta.setTitular(titularEditado);
	}
	
	public void excluiConta(int numConta) throws Exception{
            Conta conta = procuraConta(numConta);
	
            if (listaContas.contains(conta)){
                listaContas.remove(conta);
            }else {
                throw new Exception ("Conta inexistente!");
            }
	}
	
	public String listaContas(){
            if (listaContas.isEmpty()){
		return "Nenhuma conta registrada!";
            }
            else {
		String result = "";
                result = listaContas.stream().map((Conta conta) -> "Titular da Conta:\n" + conta.getTitular() + "Agência:\n" + conta.getAgencia() + "Numero da Conta:\n" + conta.getNumero() + "Saldo da Conta:\n" + conta.getSaldo()).reduce(result, String::concat);
		return result;
            }
	}
}