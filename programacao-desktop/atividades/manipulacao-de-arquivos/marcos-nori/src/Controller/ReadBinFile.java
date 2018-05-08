/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.Cliente;      
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 *
 * @author JOAO
 */
public class ReadBinFile {
    private ObjectInputStream in;
    
    public void openFile(){
        try{
            this.in = new ObjectInputStream(new FileInputStream("./file.bin"));
        }
        catch(IOException e){
            System.err.println("Error opening file.");
        }
    }
    
 public Cliente readRecords() throws IOException, ClassNotFoundException{

     Cliente c = new Cliente();
        openFile();
            while(true)
            {
               c = (Cliente) in.readObject();
               closeFile();
               return c;
            }
         
    }
    
    public void closeFile(){
        try{
            if(this.in != null) this.in.close();
        }
        catch(IOException e){
            System.err.println("Error closing file.");
        }
    }
}

