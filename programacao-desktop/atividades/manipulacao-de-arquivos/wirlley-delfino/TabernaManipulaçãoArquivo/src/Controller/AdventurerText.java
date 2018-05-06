/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Adventurer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Wirlley Delfino
 */
public class AdventurerText extends Adventurer{

    public void saveText(Adventurer a) throws IOException
    {
        FileWriter w = new FileWriter("adventurer.txt");
		PrintWriter out = new PrintWriter(w);
		out.println(a.toString());
		out.close();
		w.close();

    }
    public Adventurer readText() throws FileNotFoundException, IOException
    {
        
        FileReader r = new FileReader("adventurer.txt");
        BufferedReader in = new BufferedReader(r);
        Adventurer a = new Adventurer(in.readLine(), in.readLine());
		in.close();
		r.close();
                System.out.println(a.toString());
                return a;
                
    }
}
