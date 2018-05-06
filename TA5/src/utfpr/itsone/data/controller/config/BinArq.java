/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.itsone.data.controller.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import utfpr.itsone.data.UserData;
import utfpr.itsone.model.User;

/**
 *
 * @author Vinicius
 */
public class BinArq {

    private File file = new File("./fileUsers.bin");
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void openFileWrite() {
        try {
            this.out = new ObjectOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
    
    public void openFileRead() {
        try {
            this.in = new ObjectInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public void write() {
        openFileWrite();
        UserData.getData().getUsers().forEach(n -> {
            try {
                out.writeObject(n);
                out.flush();
            } catch (IOException ex) {
                Logger.getLogger(BinArq.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        closeFileWrite();
    }

    public void read() {
        openFileRead();
        UserData.getData().getUsers().clear();
        try{
            while(true){
		UserData.getData().addUser((User)in.readObject());
            }
        } 
        catch(IOException | ClassNotFoundException e){
        }
        closeFileRead();
        //UserData.getData().getUsers().forEach(n -> {System.out.println(n.toString());});
    }

    public void closeFileWrite() {
        try {
            if (this.out != null) {
                this.out.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }
    
    public void closeFileRead() {
        try {
            if (this.in != null) {
                this.in.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }

}
