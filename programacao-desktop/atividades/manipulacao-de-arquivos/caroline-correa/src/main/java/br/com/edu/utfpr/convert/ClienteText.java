package br.com.edu.utfpr.convert;

import br.com.edu.utfpr.domain.Cliente;

public class ClienteText extends Convertedor<Cliente, String>{
    
    public String toString(Cliente cliente){
       // int id, String nome, String cpf, String endereco, String telefone, String email
        return  cliente.getId()+";"+
                cliente.getNome() + ";" +
                cliente.getCpf()+ ";" +
                cliente.getEndereco()+ ";" +
                cliente.getTelefone()+ ";" +
                cliente.getEmail()+"\n";
    }
    
    public Cliente toObject(String text){
        String[] s = text.split(";");
        return new Cliente(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4], s[5]);
    }
}
