/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Info;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author geovannemoro
 */

public class CreateBinInfo {
    
        private ObjectOutputStream out;
        
        public void openFile(){
        try{
            this.out = new ObjectOutputStream(new FileOutputStream("./file.bin"));
        }
        catch(IOException e){
            System.err.println("Error opening file.");
        }
    }
    
    public void addRecords(Info ev){
        System.out.println(ev.toString());
        try{
            openFile();
            out.writeObject(ev);
            closeFile();
            
        }
        catch(IOException e){
            System.err.println("Error.");
        }
    }
    
    public void closeFile(){
        try{
            if(this.out != null) 
            {
                this.out.close();
            }  
        }
        catch(IOException e){
            System.err.println("Error closing file.");
        }
    }
}
