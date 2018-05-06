/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Info;
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
 * @author geovannemoro
 */

public class TextInfo extends Info{
    
    public void salveText(Info e) throws IOException
    {
        FileWriter w = new FileWriter("geova-info.txt");
		PrintWriter out = new PrintWriter(w);
		out.println(e.toString());
		out.close();
		w.close();

    }
    public Info ReadText() throws FileNotFoundException, IOException
    {
        
        FileReader r = new FileReader("geova-info.txt");
        BufferedReader in = new BufferedReader(r);
        Info ev = new Info(in.readLine(), in.readLine(), in.readLine(), in.readLine());
		in.close();
		r.close();
                System.out.println(ev.toString());
                return ev;
                
    }
}
