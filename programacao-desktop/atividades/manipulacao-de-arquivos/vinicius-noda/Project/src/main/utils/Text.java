/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.objects.persons.Address;
import main.objects.persons.LegalPerson;

/**
 *
 * @author noda
 */
public class Text {

    public static void save(String obj) {
        OutputStream os;
        try {
            os = new FileOutputStream("record.txt");
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(obj);
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static LegalPerson load() {
        try {
            InputStream is = new FileInputStream("record.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            if(s == null){
                return null;
            }
            LegalPerson p = new LegalPerson();
            p.setName(s);
            s = br.readLine();
            p.setRG(s);
            s = br.readLine();
            p.setCPF(s);
            s = br.readLine();
            ArrayList<String> tel = new ArrayList<>();
            tel.add(s);
            p.setTelephones(tel);
           
            s = br.readLine();
            Address ad = new Address();
            ad.setStreet(s);
            s = br.readLine();
            ad.setNumber(Integer.parseInt(s));
            s = br.readLine();
            ad.setBlock(s);
            p.setAddress(ad);
            
            return(p);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
