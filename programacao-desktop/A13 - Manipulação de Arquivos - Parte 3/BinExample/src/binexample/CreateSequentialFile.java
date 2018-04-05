package binexample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import objects.StudentScore;

public class CreateSequentialFile {
    
    private ObjectOutputStream out;
    
    public void openFile(){
        try{
            this.out = new ObjectOutputStream(new FileOutputStream("./file.bin"));
        }
        catch(IOException e){
            System.err.println("Error opening file.");
        }
    }
    
    public void addRecords(){
        StudentScore r1, r2;
        r1 = new StudentScore("Diogo", "Cezar", 10);
        r2 = new StudentScore("Jonas", "Pedro", 8);
        try{
            out.writeObject(r1);
            out.writeObject(r2);
        }
        catch(IOException e){
            System.err.println("Error.");
        }
    }
    
    public void closeFile(){
        try{
            if(this.out != null) this.out.close();
        }
        catch(IOException e){
            System.err.println("Error closing file.");
        }
    }
}
