package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author fabricio@utfpr.edu.br
 */
public class TestaArquivo3 {
    private File arquivo = null;
    private BufferedReader entrada = null;
    private BufferedWriter escritorbuffer = null;

    public void abrirarquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }
        arquivo = fileChooser.getSelectedFile();
        System.out.println(arquivo);

        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                entrada = new BufferedReader(new FileReader(arquivo));
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean Escreve(
            String aux,
            boolean append) {
        try {
            escritorbuffer
                    = new BufferedWriter(
                            new FileWriter(arquivo, append));
            escritorbuffer.write(aux);
            escritorbuffer.close();
            return true;
        } catch (IOException erro) {
            System.err.println("Erro na escrita de arquivo: " + erro);
        }
        return false;
    }

    public String Le() {
        StringBuilder str = new StringBuilder();
        try {
            entrada = new BufferedReader(
                    new FileReader(arquivo));
            while (entrada.ready()) {
                str.append(entrada.readLine()).append("\n");
            }
            entrada.close();
            return str.toString();
        } catch (IOException erro) {
            System.err.println("Erro na leitura de arquivo: " + erro);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        File diretorio = new File("/home/fabricio/temp/");
        diretorio.mkdir();
        
        TestaArquivo3 obj = new TestaArquivo3();
        obj.arquivo = new File(diretorio, "log.txt");        
        obj.Escreve("ola java 1!\n", false);
        obj.Escreve("ola java 2!\n", true);
        obj.Escreve("ola java 3!\n", true);
        obj.abrirarquivo();
        if (obj.entrada != null) {
            System.out.println("Leitura do Arquivo: ");
            //System.out.println(obj.Le());
            JOptionPane.showMessageDialog(null, obj.Le());
        }
    }
}
