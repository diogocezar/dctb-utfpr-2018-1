/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.User;
import com.google.gson.Gson;

/**
 *
 * @author Felipe Bueno de Paula
 */
public class UserFileControl {
    
    public void saveJson(String file, User user) throws FileNotFoundException, IOException {
        String json = new Gson().toJson(user, user.getClass());
        try (FileWriter f = new FileWriter(file)) {
            f.write(json);
            f.close();
        }
    }
    
    public User loadJson(String file) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        String json = buffer.readLine();
        User user = new Gson().fromJson(json, User.class);
        return user;
    }
    
    public void saveText(String file, User user) throws IOException {
        try (FileWriter f = new FileWriter(file)) {
            f.write(user.toString());
        }
    }
    
    public User loadText(String file) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(fileReader);
        String line = buffer.readLine();
        
        String data[] = line.split(";");
        return new User(data[0], data[1], data[2]);
    }
    
    public void saveBinary(String file, User user) throws FileNotFoundException, IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            output.writeObject(user);
        }
    }
    
    public User loadBinary(String file) throws ClassNotFoundException, IOException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        return (User) input.readObject();
    }
    
}
