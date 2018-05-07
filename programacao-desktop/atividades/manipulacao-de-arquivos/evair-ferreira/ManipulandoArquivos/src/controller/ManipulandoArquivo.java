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
import model.Cadastro;

/**
 *
 * @author phoebo
 */
public class ManipulandoArquivo {
    
    private String[] vet = {"Nome -> ", " \nEndereco -> ", " \nSenha -> ", " \nNumero -> "};
    
    public void recuperarArquivoTXT() {
        FileReader lendo = null;
        String[] valor = new String[4];
        
        try {
            lendo = new FileReader("a.txt");
            BufferedReader in = new BufferedReader(lendo);
            String aux = in.readLine();

            for(int i = 0; i < valor.length; i++){
                if(aux != null){
                valor[i] = aux;
                aux = in.readLine();
                }
            }
            in.close();
            lendo.close();
            this.exibeArquivoRecuperadoTXT(valor);
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo nao foi salvo!");
        }
    }
    
    private void exibeArquivoRecuperadoTXT(String[] valor) {
        String txt = "";
        for (int i = 0; i < valor.length; i++) {
            txt += valor[i] + valor[i];
        }
        mesagemUsuarioRecuperado(txt);
    }
    
    
    public void salvarArquivoTXT(String[] dados){
        FileWriter w = null;
        try {
            w = new FileWriter("a.txt");
            PrintWriter out = new PrintWriter(w);
            for (String valor : dados) {
                out.println(valor);
            }
            out.close();
            w.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo nao foi salvo!");
        }
        JOptionPane.showMessageDialog(null, "Arquivo salvo!");
    }  
    
    public void recuperarArquivoBinario() {
        ObjectInputStream in;
        Cadastro user = null;
        try {
            in = new ObjectInputStream(new FileInputStream("b.bin"));
            while(true){
		user = (Cadastro) in.readObject();
                String text = vet[0] + user.getNome() + vet[1] + user.getEndereco() + vet[2] + user.getUf() + vet[3] + user.getSenha();
                mesagemUsuarioRecuperado(text);
                if (in != null) in.close();
            }
        }
        catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, " Erro na leitura do Arquivo!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManipulandoArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void salvarArquivoBinario(Cadastro data){
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream("b.bin"));
            out.writeObject(data);
            if (out != null) out.close();
            mensagemSalvar("bin");
        } catch (IOException ioException) {
            mensagemErrorSalvar("binário");
        }
    }
    
    public void salvarArquivoJSON(Cadastro data){
        try{
            FileWriter w;
            w = new FileWriter("j.json");
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
    
    private String convertToJSON(Cadastro data){
	String json = new Gson().toJson(data, Cadastro.class);
	return json;
    }
    
    private void mensagemSalvar(String format) {
        JOptionPane.showMessageDialog(null, "Arquivo salvo!");
    }
    
    private void mensagemErrorSalvar(String format) {
        JOptionPane.showMessageDialog(null, " O arquivo não pode ser salvo!");
    }
    
    private void mensagemErrorRecuperar(String format) {
        JOptionPane.showMessageDialog(null, " O arquivo não pode ser salvo!");
    }
    
    private void mesagemUsuarioRecuperado(String recuperado) {
        JTextArea aux1 = new JTextArea(recuperado);
        JScrollPane aux = new JScrollPane(aux1){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(250, 200);
            }
        };
        JOptionPane.showMessageDialog(null, aux, "Usuario Encontrado", JOptionPane.INFORMATION_MESSAGE);
    }
}
