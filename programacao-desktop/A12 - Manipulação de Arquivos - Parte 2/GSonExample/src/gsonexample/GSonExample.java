
package gsonexample;

import com.google.gson.Gson;
import classes.Person;
import classes.Phone;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GSonExample {
    
    public Person generateSample(){
        Person p = new Person();
        p.setAge(32);
        p.setFirstName("Diogo Cezar");
        p.setLastName("Teixeira Batista");
        
        Phone p1 = new Phone();
        p1.setNumber("0000-0000");
        p1.setType("Pessoal");
        
        Phone p2 = new Phone();
        p2.setNumber("0000-0000");
        p2.setType("Empresarial");
        
        p.getPhones().add(p1);
        p.getPhones().add(p2);
        
        return p;
    }
    
    public String convertToJSON(){
        String json = new Gson().toJson(this.generateSample(), Person.class);
        return json;
    }
    
    public Person converToPerson(String json){
        Person p = new Gson().fromJson(json, Person.class);
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

    public static void main(String[] args) {
        GSonExample me = new GSonExample();
        //me.saveJSON("./sample.json", me.convertToJSON());
        Person p = me.converToPerson(me.loadJSON("./sample.json"));
        System.out.println("Nome da pessoa recuperada: " + p.getFirstName());
    }

}
