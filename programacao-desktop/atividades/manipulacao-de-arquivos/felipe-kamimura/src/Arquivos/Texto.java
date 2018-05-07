/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos;

import Classes.Cliente;
import java.io.*;
/**
 *
 * @author kamimuraf
 */
public class Texto {
    public void TextFileWriter(Cliente c) throws IOException{
        FileWriter w = new FileWriter("arquivoTexto.txt"); 
        PrintWriter out = new PrintWriter(w);
        out.println(c.getNome());
        out.println(c.getCpf());
        out.println(c.getEndereço());
        out.println(c.getTelefone());
        out.println(c.getEmail());
        out.close();
        w.close();
    }
    public Cliente TextFileReader() throws IOException{
       FileReader r = new FileReader("arquivoTexto.txt");
        BufferedReader in = new BufferedReader(r);
        Cliente novo = new Cliente();
        
        String line = in.readLine();
        novo.setNome(line);
        line = in.readLine();
        novo.setCpf(line);
        line = in.readLine();
        novo.setEndereço(line);
        line = in.readLine();
        novo.setTelefone(line);
        line = in.readLine();
        novo.setEmail(line);
 
        in.close();
        r.close(); 
        return novo;
    }
}
