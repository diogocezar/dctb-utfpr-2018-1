/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Adventurer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 *
 * @author Wirlley Delfino
 */
public class AdventurerReadBinary {
private ObjectInputStream in;
    
    public void openFile(){
        try{
            in = new ObjectInputStream(new FileInputStream("./file.bin"));
        }
        catch(IOException e){
            System.err.println("Error opening file.");
        }
    }
    
    public Adventurer readRecords() throws IOException, ClassNotFoundException{
        Adventurer a = new Adventurer();
        openFile();
            while(true)
            {
               a = (Adventurer) in.readObject();
               closeFile();
               return a;
            }
         
    }
    
    public void closeFile(){
        try{
            if(in != null) in.close();
        }
        catch(IOException e){
            System.err.println("Error closing file.");
        }
    }    
}
