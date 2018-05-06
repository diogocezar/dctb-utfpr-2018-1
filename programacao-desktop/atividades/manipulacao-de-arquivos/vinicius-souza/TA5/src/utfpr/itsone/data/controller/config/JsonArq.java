/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.itsone.data.controller.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utfpr.itsone.data.UserData;
import utfpr.itsone.model.User;

/**
 *
 * @author Vinicius
 */
public class JsonArq {

    private File file = new File("./fileUsers.json");

    public void write() {
        try {
            FileWriter w;
            w = new FileWriter(file);
            w.write(convertToJSON());
            w.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao salvar (arquivo não encontrado): " + ex.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public String convertToJSON() {
        TypeToken<List<User>> token = new TypeToken<List<User>>() {
        };
        String json = new Gson().toJson(UserData.getData().getUsers(), token.getType());
        return json;
    }

    public void read() {
        TypeToken<List<User>> token = new TypeToken<List<User>>() {
        };

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonArq.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<User> users = new Gson().fromJson(br, token.getType());
        UserData.getData().getUsers().clear();
        UserData.getData().addUser(users);
        /*UserData.getData().getUsers().forEach(n -> {
            System.out.println(n.toString());
        });*/
    }
}
