/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Evento;
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
 * @author MAGNO
 */
public class TextoEvento extends Evento{
    
    public void salvaTexto(Evento e) throws IOException
    {
        FileWriter w = new FileWriter("magno-evento.txt");
		PrintWriter out = new PrintWriter(w);
		out.println(e.toString());
		out.close();
		w.close();

    }
    public Evento lerTexto() throws FileNotFoundException, IOException
    {
        
        FileReader r = new FileReader("magno-evento.txt");
        BufferedReader in = new BufferedReader(r);
        Evento ev = new Evento(in.readLine(), in.readLine(), in.readLine(), in.readLine());
		in.close();
		r.close();
                System.out.println(ev.toString());
                return ev;
                
    }
}
