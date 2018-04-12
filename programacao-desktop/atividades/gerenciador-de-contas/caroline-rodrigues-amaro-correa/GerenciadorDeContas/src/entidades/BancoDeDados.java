package entidades;

import java.util.HashMap;


public class BancoDeDados {
    
    private static HashMap<String,Conta> listaDeContas = new HashMap<>();
    
    public static void addConta(Conta conta){
        listaDeContas.put(conta.getConta(), conta);
    }
    
    
    
    public static Conta getConta(String numeroDaConta){
        return listaDeContas.get(numeroDaConta);
    }
    
    public static boolean deletarConta(String numeroDaConta){
        return listaDeContas.remove(numeroDaConta) != null;
    }
    
    public static HashMap<String,Conta> listContas(){
        return listaDeContas;
    }
}
