/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Object.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author marcos
 */
public class TxtCliente extends Cliente{

    public TxtCliente(String nome, String cpf, String endereco, String cidade, String email, String telefone) {
        super(nome, cpf, endereco, cidade, email, telefone);
    }

    public TxtCliente() {
     }
     public void salvaTexto(Cliente c) throws IOException
    {
        FileWriter w = new FileWriter(".txt");
		PrintWriter out = new PrintWriter(w);
		out.println(c.toString());
		out.close();
		w.close();
}
     public Cliente lerTexto() throws FileNotFoundException, IOException
    {
        
        FileReader r = new FileReader(".txt");
        BufferedReader in = new BufferedReader(r);
        Cliente cl = new Cliente(in.readLine(), in.readLine(), in.readLine(), in.readLine(),
        in.readLine(), in.readLine());
		in.close();
		r.close();
                System.out.println(cl.toString());
                return cl;
                
    }
}
