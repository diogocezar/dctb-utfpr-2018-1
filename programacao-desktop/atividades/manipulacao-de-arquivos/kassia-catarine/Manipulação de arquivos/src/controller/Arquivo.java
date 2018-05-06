/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Usuario;

/**
 *
 * @author akira
 */
public class Arquivo {
    
    private String[] labels = {"Nome: ", "\nEmail: ", "\nSenha: ", "\nNº Cartão: "};
    
    public void recuperarArquivoTXT() {
        FileReader r = null;
        String[] dados = new String[4];
        try {
            r = new FileReader("usuario.txt");
            BufferedReader in = new BufferedReader(r);
            String line = in.readLine();
            int i = 0;
            while(line != null){
                dados[i] = line;
                line = in.readLine();
                i++;
            }
            in.close();
            r.close();
            this.exibeArquivoRecuperadoTXT(dados);
        } catch (IOException ex) {
            mensagemErrorRecuperar("txt");
        }
    }
    
    private void exibeArquivoRecuperadoTXT(String[] dados) {
        String txt = "";
        for (int i = 0; i < dados.length; i++) {
            txt += labels[i] + dados[i];
        }
        mesagemUsuarioRecuperado(txt);
    }
    
    
    public void salvarArquivoTXT(String[] dados){
        FileWriter w = null;
        try {
            w = new FileWriter("usuario.txt");
            PrintWriter out = new PrintWriter(w);
            for (String dado : dados) {
                out.println(dado);
            }
            out.close();
            w.close();
        } catch (IOException ex) {
            mensagemErrorSalvar("txt");
        }
        mensagemSalvar("txt");
    }  
    
    public void recuperarArquivoJSON() {
        FileReader r = null;
        String user = "";
        try {
            r = new FileReader("usuario.json");
            BufferedReader in = new BufferedReader(r);
            String line = in.readLine();
            while(line != null){
                user += line;
                line = in.readLine();
            }
            in.close();
            r.close();
            mesagemUsuarioRecuperado(user);
        } catch (IOException ex) {
            mensagemErrorRecuperar("json");
        }
    }
    
    
    public void salvarArquivoJSON(Usuario data){
        try{
            FileWriter w;
            w = new FileWriter("usuario.json");
            w.write(this.convertToJSON(data));
            w.close();
            mensagemSalvar("json");
        }catch (FileNotFoundException ex) {
            System.out.println("Erro : " + ex.getMessage());
            mensagemErrorSalvar("JSON");
        }
        catch(IOException e){
            System.out.println("Erro : " + e.getMessage());
            mensagemErrorSalvar("json");
        }
    }
    
    public void recuperarArquivoBinario() {
        ObjectInputStream in;
        Usuario user = null;
        try {
            in = new ObjectInputStream(new FileInputStream("usuario.bin"));
            while(true){
		user = (Usuario) in.readObject();
                String text = labels[0] + user.getNome() + labels[1] + user.getEmail() + labels[2] + user.getSenha() + labels[3] + user.getCpf();
                mesagemUsuarioRecuperado(text);
                if (in != null) in.close();
            }
        }
        catch (IOException ioException) {
                System.err.println("Error opening file.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void salvarArquivoBinario(Usuario data){
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream("usuario.bin"));
            out.writeObject(data);
            if (out != null) out.close();
            mensagemSalvar("bin");
        } catch (IOException ioException) {
            mensagemErrorSalvar("binário");
        }
    }
    
    private String convertToJSON(Usuario data){
	String json = new Gson().toJson(data, Usuario.class);
	return json;
    }
    
    private void mensagemSalvar(String format) {
        JOptionPane.showMessageDialog(null, "Dados salvos com sucesso no arquivo chamado: 'usuario."+ format +"'", "Arquivo Salvo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mensagemErrorSalvar(String format) {
        JOptionPane.showMessageDialog(null, "Erro ao salvar no formato " + format, "Erro ao salvar", 0);
    }
    
    private void mensagemErrorRecuperar(String format) {
        JOptionPane.showMessageDialog(null, "Erro ao recuperar no formato " + format, "Erro ao recuperar", 0);
    }
    
    private void mesagemUsuarioRecuperado(String recuperado) {
        JTextArea jta = new JTextArea(recuperado);
        JScrollPane jsp = new JScrollPane(jta){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(250, 200);
            }
        };
        JOptionPane.showMessageDialog(null, jsp, "Usuario Recuperado", JOptionPane.INFORMATION_MESSAGE);
    }
}
