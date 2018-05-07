/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.itsone.data.controller.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import utfpr.itsone.data.UserData;
import utfpr.itsone.model.User;

/**
 *
 * @author Vinicius
 */
public class TextArq {

    private File file = new File("./fileUsers.txt");
    private PrintWriter pw;
    private Scanner in;

    public void openFileWrite() {
        try {
            pw = new PrintWriter(new FileWriter(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public void openFileRead() {
        try {
            in = new Scanner(new BufferedReader(new FileReader(file)));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public void write() {
        openFileWrite();
        UserData.getData().getUsers().forEach(n -> {
            pw.println(n.toString());
        });
        closeFileWrite();
    }

    public void read() {
        openFileRead();
        UserData.getData().getUsers().clear();
        while (in.hasNextLine()) {
            String currentLine = in.nextLine();
            Scanner src = new Scanner(currentLine);
            src.useDelimiter("[;{}]+");
            UserData.getData().addUser(new User(src.next(), src.next(), src.next()));
        }
        /*UserData.getData().getUsers().forEach(n -> {
            System.out.println(n.toString());
        });*/
        closeFileRead();
    }

    public void closeFileRead() {
        if (this.in != null) {
            this.in.close();
        }
    }

    public void closeFileWrite() {
        if (this.pw != null) {
            this.pw.close();
        }
    }
}
