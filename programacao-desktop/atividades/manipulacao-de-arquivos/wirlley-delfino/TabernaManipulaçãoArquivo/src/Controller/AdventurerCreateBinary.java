/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Adventurer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Wirlley Delfino
 */
public class AdventurerCreateBinary {

    private ObjectOutputStream out;
        
        public void openFile(){
        try{
            out = new ObjectOutputStream(new FileOutputStream("./file.bin"));
        }
        catch(IOException e){
            System.err.println("Error opening file.");
        }
    }

    public void addRecords(Adventurer ad){
        System.out.println(ad.toString());
        try{
            openFile();
            out.writeObject(ad);
            closeFile();
            
        }
        catch(IOException e){
            System.err.println("Error.");
        }
    }
    
    public void closeFile(){
        try{
            if(out != null) 
            {
                out.close();
            }  
        }
        catch(IOException e){
            System.err.println("Error closing file.");
        }
    }
}
