/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Info;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author geovannemoro
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
    
    public Info readRecords() throws IOException, ClassNotFoundException{
        Info e = new Info();
        openFile();
            while(true)
            {
               e = (Info) in.readObject();
               closeFile();
               return e;
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
