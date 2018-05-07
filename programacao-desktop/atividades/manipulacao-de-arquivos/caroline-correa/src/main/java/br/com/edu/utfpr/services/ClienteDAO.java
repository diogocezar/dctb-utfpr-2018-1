package br.com.edu.utfpr.services;

import br.com.edu.utfpr.convert.ClienteText;
import br.com.edu.utfpr.convert.Convertedor;
import br.com.edu.utfpr.domain.Cliente;
import br.com.edu.utfpr.utils.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;

public class ClienteDAO {
    
    protected String file = "clientes.txt";
    
    protected Convertedor convertedor;
    
    public ClienteDAO(Convertedor convertedor){
        this.convertedor = convertedor;
    }
    public String salvar(Cliente cliente){
        if(this.buscar(cliente.getId()) == null){
             System.out.println("Novo");
             FileUtils.append(this.file, (String) this.convertedor.toString(cliente));
             return "NEW";
        }else{
             System.out.println("altera");
            // Altera o cliente já existente
             this.alterar(cliente);
             return "UPDATE";
        }
    }
    
    public Cliente buscar(int id){
        ArrayList<String> linhas = FileUtils.getLines(this.file);
        HashMap<Integer, Cliente> clientes = new HashMap<>();
        Cliente cliente;
        for(String linha : linhas){
            cliente = (Cliente) this.convertedor.toObject(linha);
            clientes.put(cliente.getId(), cliente);
        }
        
        return clientes.get(id);
    }
    
    protected void alterar(Cliente clienteAlterado){
        ArrayList<String> linhas = FileUtils.getLines(this.file);
        String texto = "";
        for(String linha : linhas){
            Cliente clienteAtual =  (Cliente) this.convertedor.toObject(linha);
            if(clienteAtual.getId() == clienteAlterado.getId()){
                linha = (String) this.convertedor.toString(clienteAlterado);
            }
                
            texto = texto + linha;
        }
        FileUtils.writer(this.file, texto);
    }
}
