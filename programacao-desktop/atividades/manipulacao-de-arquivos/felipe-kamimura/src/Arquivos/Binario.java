/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos;

import Classes.Cliente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author kamimuraf
 */
public class Binario {
    
   //------------------------------------------------------------Salvando arquivo bin 
    private ObjectOutputStream out;
    public void openFileWrite(){
        try{
            this.out = new ObjectOutputStream
                    (new FileOutputStream ("./arquivoBinario.bin"));
        }catch(IOException e){
            System.err.println("Error opening file");
        }
    }
    
    public void addRecords(Cliente c){
        try{
            out.writeObject(c);
        }
        catch(IOException e){
            System.err.println("Erro.");
        }
    }
    
    public void closeFileOut(){
        try{
            if(this.out != null) this.out.close();
        }
        catch(IOException e){
            System.err.println("Error closing file");
        }
    }
    
    //-----------------------------------------------------------------Lendo arquivo bin
    
    private ObjectInputStream in;
    public void openFileRead(){
        try{
            this.in = new ObjectInputStream
                    (new FileInputStream ("./arquivoBinario.bin"));
        }catch(IOException e){
            System.err.println("Error opening file");
        }
    }
    public Cliente readRecords(){
        Cliente c = new Cliente();
        try{
            c = (Cliente) in.readObject();
            
        }
        
        catch(IOException | ClassNotFoundException e){
        
        }
     return c;
    }
    
    public void closeFileIn(){
        try{
            if(this.in != null) this.in.close();
        }
        catch(IOException e){
        System.err.println("Error closing file");
        }
    }
}
