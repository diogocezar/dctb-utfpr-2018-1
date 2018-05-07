/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

import com.google.gson.Gson;
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
public class JSON {
    public static void save(LegalPerson p) {
        OutputStream os;
        try {
            os = new FileOutputStream("record.json");
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(new Gson().toJson(p, LegalPerson.class));
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static LegalPerson load() {
        try {
            InputStream is = new FileInputStream("record.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            String json = s;
            while(s != null){
                s=br.readLine();
                if(s != null){
                    json+=s;
                }
            }
            System.out.println(json);
            return(new Gson().fromJson(json,LegalPerson.class));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
