/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.edu.utfpr.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Caroline
 */
public class FileUtils {


    public static void writer(String arquivo, String conteudo) {
        FileWriter file;
        try {
            file = new FileWriter(arquivo);
            file.write(conteudo);
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void append(String arquivo, String conteudo) {
        FileWriter file;
        try {
            file = new FileWriter(arquivo, true);
            file.write(conteudo);
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<String> getLines(String arquivo){
        ArrayList<String> linhas = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(arquivo));
            while(scanner.hasNextLine()){
                linhas.add(scanner.nextLine()+"\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linhas;
    }
    
    public static String getContent(String arquivo){
        ArrayList<String> linhas = new ArrayList<>();
        try {
           return new String(Files.readAllBytes(Paths.get(arquivo)));
        } catch (Exception ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
