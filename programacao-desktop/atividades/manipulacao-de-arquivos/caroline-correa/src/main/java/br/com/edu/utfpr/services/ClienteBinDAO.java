package br.com.edu.utfpr.services;

import br.com.edu.utfpr.convert.ClienteText;
import br.com.edu.utfpr.convert.Convertedor;
import br.com.edu.utfpr.domain.Cliente;
import br.com.edu.utfpr.utils.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteBinDAO {

    protected String file = "clientes.bin";
    protected Convertedor convertedor;
    protected static HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
    
    public ClienteBinDAO(){
        this.getDadosDoArquivo();
    }

    public String salvar(Cliente cliente) {
        if (this.buscar(cliente.getId()) != null) {
            clientes.remove(cliente.getId());
        }
        clientes.put(cliente.getId(), cliente);
        this.salvarDadosNoArquivo();
        if (this.buscar(cliente.getId()) != null) {
            return "NEW";
        } else {
            return "UPDATE";
        }
    }

    public Cliente buscar(int id) {
        return clientes.get(id);
    }

    private void getDadosDoArquivo() {
        FileInputStream arquivoLeitura;
        try {
            arquivoLeitura = new FileInputStream(file);
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            clientes = (HashMap<Integer, Cliente>) objLeitura.readObject();
        } catch (Exception ex) {
            Logger.getLogger(ClienteBinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     

    }

    private void salvarDadosNoArquivo() {
        try {
            FileOutputStream arquivoGrav = new FileOutputStream(file);
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            objGravar.writeObject(clientes);
            objGravar.flush();
            objGravar.close();
            arquivoGrav.flush();
            arquivoGrav.close();
        } catch (Exception ex) {
            Logger.getLogger(ClienteBinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
