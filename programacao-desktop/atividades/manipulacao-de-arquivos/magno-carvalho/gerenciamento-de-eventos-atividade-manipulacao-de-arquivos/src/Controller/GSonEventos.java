/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Evento;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MAGNO
 */
public class GSonEventos {

    
    public String convertToJSON(Evento e){
        String json = new Gson().toJson(e, Evento.class);
        return json;
    }
    
    public Evento converToPerson(String json){
        Evento p = new Gson().fromJson(json, Evento.class);
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
            System.out.println("Erro ao salvar (arquivo não encontrado): " + ex.getMessage());
        }
        catch(IOException e){
            System.out.println("Erro ao salvar: " + e.getMessage());
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
            System.out.println("Erro ao ler (arquivo não encontrado): " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Erro ao ler : " + ex.getMessage());
        }
        return null;
    }

}
