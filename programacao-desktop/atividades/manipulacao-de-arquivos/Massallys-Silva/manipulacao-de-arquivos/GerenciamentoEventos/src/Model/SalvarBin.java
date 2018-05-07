package Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SalvarBin implements Serializable{
    private ObjectInputStream entrada;
    private ObjectOutputStream saida;
    
    public void criarArquivo(){
        try{
                saida = new ObjectOutputStream(new FileOutputStream("cadastrarEvento.bin"));
            }catch(IOException io){
                    System.err.println("erro ao criar arquivo");
            }
    }
    
    public void recuperarArquivo(){
        try{
            entrada = new ObjectInputStream(new FileInputStream("cadastrarEvento.bin"));
        }catch(IOException io){
                System.err.println("erro ao criar arquivo");
        }
        
    }
    
    /*public void lerRegistro(){
        try{
            while(true){
                resultado = in.readObject();
            }
        }catch(IOException io){
            System.err.println("erro ao recupear arquivo");
        }
    }
    */
}
