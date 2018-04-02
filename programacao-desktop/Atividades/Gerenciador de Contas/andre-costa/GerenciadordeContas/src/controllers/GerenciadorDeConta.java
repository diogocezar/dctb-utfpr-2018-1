/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author andre
 */
import java.util.Iterator;
import model.BancoElegante;
import model.Conta;
public class GerenciadorDeConta {
    
    
public boolean criarConta(String titular,String agencia,int numero,double saldo){
    if(existeConta(numero)==false){
        BancoElegante.getInstance().getContas().add(new Conta(titular,agencia,numero,saldo));
    return true;
    }
    else{
        return false;
    }
}
   
public double pesquisarSaldo(int numeroConta) throws Exception{
    if(existeConta(numeroConta)){
        return returnSaldo(numeroConta);
    }else{
        throw new Exception("A conta nao existe");
    }
}

public String pesquisarAgencia(int numeroConta) throws Exception{
    String agencia;
    if(existeConta(numeroConta)){
        agencia = returnAgencia(numeroConta);
        if(agencia.equals("")){
            throw new Exception("Não foi cadastrado Agencia");
        }else{
            return agencia;
        }
    }else{
        throw new Exception("A conta nao existe");
    }
}

public boolean atualizarNomeDoTitular(int numeroConta,String novoNomeTitular) throws Exception{
    if(novoNomeTitular.equals("")){
        throw new Exception("Digite um nome para o titular");
    }else if(existeConta(numeroConta)){
        return novoNomeConta(numeroConta,novoNomeTitular);
    }else{
        throw new Exception("A conta nao existe");
    }
}

public boolean removerConta(int numeroConta) throws Exception{
    if(existeConta(numeroConta)){
        if(removeConta(numeroConta)){
            return true;
        }
        else{
            throw new Exception("Não foi possivel remover a conta");
        }
    }else{
        throw new Exception("A conta nao existe");
    }
}

public String listarContas(){
    String contas = "Não existe nenhuma conta cadastrada";
    
    if(BancoElegante.getInstance().getContas().size()>0){
        contas = "";
        for(Conta c: BancoElegante.getInstance().getContas()){
            contas += "\n" +"Titular: "+c.getTitular() + "  " +
                            "Agencia: "+ c.getAgencia() + "  " +
                            "Numero: "+ Integer.toString(c.getNumero())  + "  "+
                            "Saldo:" + Double.toString(c.getSaldo());
        }
    } 
     return contas;
}
   
//funções auxiliares   
public boolean existeConta(int numero){

    for(Conta c: BancoElegante.getInstance().getContas()){
        if(numero == c.getNumero()){
            return true;
        }
    }
    
    return false;
}

public double returnSaldo(int numeroConta){
    for(Conta c:BancoElegante.getInstance().getContas()){
        if(c.getNumero() == numeroConta){
            return c.getSaldo();
        }
    }
    return -1;
}

public String returnAgencia(int numeroConta){
    for(Conta c:BancoElegante.getInstance().getContas()){
        if(c.getNumero() == numeroConta){
            return c.getAgencia();
        }
    }
    return "";
}

public boolean novoNomeConta(int numeroConta,String novoNome){
    for (Iterator<Conta> it = BancoElegante.getInstance().getContas().iterator(); it.hasNext();) {
        Conta c = it.next();
        if(c.getNumero()==numeroConta){
            c.setTitular(novoNome);
            return true;
        }
    }
    return false;
}

public boolean removeConta(int numeroConta){
    for (Iterator<Conta> it = BancoElegante.getInstance().getContas().iterator(); it.hasNext();) {
        Conta c = it.next();
        if(c.getNumero()==numeroConta){
            it.remove();
            return true;
        }
    }
    return false;
}

}
