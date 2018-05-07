/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.objects.persons.JuridicalPerson;
import main.objects.persons.LegalPerson;

/**
 *
 * @author noda
 */
public class Bin {
    public static void saveBin(LegalPerson p){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("record.bin"));
            
            out.writeObject(p);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static LegalPerson loadBin(){
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("record.bin"));
            return (LegalPerson) in.readObject();
        }catch(EOFException ex){
            System.out.println("Caiu aqui");
        }catch (FileNotFoundException ex) {
            System.out.println("ou aqui.");
        }catch ( ClassNotFoundException ex){
            System.out.println("Ou aqui 3.");
        } catch (IOException ex) {
            Logger.getLogger(Bin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
