/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Adventurer;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Wirlley Delfino
 */
public class AdventurerGSon {
    public String convertToJSON(Adventurer a){
        String json = new Gson().toJson(a, Adventurer.class);
        return json;
    }
    
    public Adventurer converToPerson(String json){
        Adventurer p = new Gson().fromJson(json, Adventurer.class);
        return p;
    }
    
    public void saveJSON(String file, String json){
        try{
            FileWriter w;
            w = new FileWriter(file);
            w.write(json);
            w.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public String loadJSON(String file){
        try{
            FileReader r;
            r = new FileReader(file);
            BufferedReader in = new BufferedReader(r);
            String buffer = in.readLine();
            String all = "";
            while(buffer != null){
                all += buffer;
                buffer = in.readLine();
            }
            return all;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found): " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Read error: " + ex.getMessage());
        }
        return null;
    }
}
