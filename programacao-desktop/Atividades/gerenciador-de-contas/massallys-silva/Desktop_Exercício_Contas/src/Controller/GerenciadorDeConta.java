package Controller;

import java.util.ArrayList;

public class GerenciadorDeConta {
    int numero;
    double saldo;
    String agencia, titular;
    
    ArrayList <String> conta = new ArrayList();
    
    public void criarConta(String titular, String agencia, int numero, double saldo){
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        
        
        conta.add(titular);
        conta.add(agencia);
        conta.add(Integer.toString(numero));
        conta.add(Double.toString(saldo));
    }
    
    public String listarContas(){
        String texto = "";
        
        for(String contas : conta) {
          texto += contas;
        }
        
        return texto;
    }
    
    public void removerConta(int numero){
        if(this.numero == numero)
            conta.removeAll(conta);
    }
    
    public void atualizarNomeDoTitular(int numero, String titular){
        if(this.numero == numero)  
            conta.add(titular);
    }
    
    public String pesquisarAgencia(int numero){
        if(this.numero == numero){}
        
        return agencia;      
    }
    
    public double pesquisarSaldo(int numero){
        if(this.numero == numero){}
        
        return saldo;
    }

}
