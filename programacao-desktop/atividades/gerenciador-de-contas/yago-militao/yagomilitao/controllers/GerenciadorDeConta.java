/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import principal.Conta;

/**
 *
 * @author kamil
 */
public class GerenciadorDeConta {
    
    List<Conta> lista;
    
    public GerenciadorDeConta(){
        lista = new ArrayList<>();
    }
    
    public void criarConta(String titularConta, String agenciaConta, int numeroConta, double saldoConta){
        Conta conta1 = new Conta();
        conta1.setTitularConta(titularConta);
        conta1.setAgenciaConta(agenciaConta);
        conta1.setNumeroConta(numeroConta);
        conta1.setSaldoConta(saldoConta);
        
        insere(conta1);
    }
    
    public void insere(Conta conta1){
        lista.add(conta1);
    }
    
    public String listarContas(){
        
        if(lista.isEmpty()){
            return "Nao existem contas";
            
        }else {
            String retorno="";
            retorno = lista.stream().map((Conta conta1)->
                    "\nTitular: " + conta1.getTitularConta() + "\nAgencia: " + conta1.getAgenciaConta() + "\nNumero da Conta: " + conta1.getNumeroConta() + "\nSaldo da Conta: " + conta1.getSaldoConta()).reduce(retorno, String::concat);
            return retorno;
        }
    }
    
    public Conta pesquisarConta(int numeroConta){
            for (Conta conta1 : lista){
            	if (conta1.getNumeroConta()==numeroConta){
                    return conta1;
		}
            }		
		return new Conta();
	}
    
    public void removerConta (int numeroConta) throws Exception{
        Conta conta1 = pesquisarConta(numeroConta);
        
        if(lista.contains(conta1)){
            lista.remove(conta1);
        }else {
            throw new Exception ("Essa conta nao existe");
        }
    }
    
   public void atualizarNomeDoTitular(int numeroConta, String titularNovo) throws Exception {
            Conta conta1 = pesquisarConta(numeroConta);
		
            if (conta1.getNumeroConta()==0){
		throw new Exception("Essa conta nao existe");
            }
         conta1.setTitularConta(titularNovo);
	}
    
   public String pesquisarAgencia(int numeroConta) throws Exception {
            Conta conta1 = pesquisarConta(numeroConta);
	
            if (conta1.getNumeroConta()==0){
			throw new Exception("Essa conta nao existe");
            }
            return conta1.getAgenciaConta();
	}
   
   public double pesquisarSaldo(int numeroConta) throws Exception {
            Conta conta1 = pesquisarConta(numeroConta);
            
            if (conta1.getNumeroConta()==0){
		throw new Exception("Essa conta nao existe");
            }
            return conta1.getSaldoConta();
	}
}
