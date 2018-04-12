package binexample;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import objects.StudentScore;

public class ReadSequentialFile {
    
    private ObjectInputStream in;
    
    public void openFile(){
        try{
            this.in = new ObjectInputStream(new FileInputStream("./file.bin"));
        }
        catch(IOException e){
            System.err.println("Error opening file.");
        }
    }
    
    public void readRecords(){
	StudentScore r;
        try{
            while(true){
		r = (StudentScore) in.readObject();
		System.out.println(r.getFirstName());
            }
        } 
        catch(IOException | ClassNotFoundException e){
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
