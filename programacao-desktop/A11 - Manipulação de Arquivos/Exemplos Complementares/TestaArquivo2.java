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
public class TestaArquivo2 {

    private BufferedReader entrada = null;

    private void abrirarquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File arquivo = fileChooser.getSelectedFile();
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

    public static void main(String[] args) throws IOException {
        File diretorio = new File("/home/fabricio/temp/");
        diretorio.mkdir();

        File arquivo = new File(diretorio, "lixo.txt");
        FileWriter escritor = new FileWriter("/home/fabricio/temp/log.txt", true);
        BufferedWriter escritorbuffer = new BufferedWriter(escritor);
        escritorbuffer.write("ola java!");
        escritorbuffer.flush();
        escritorbuffer.write("ola java 2!");
        escritorbuffer.close();
        escritor.close();

        /*
        FileReader leitor = new FileReader(arquivo);
        BufferedReader leitorbuffer = new BufferedReader(leitor);
         */
        TestaArquivo2 obj = new TestaArquivo2();
        obj.abrirarquivo();
        if (obj.entrada != null) {
            System.out.println("Leitura do Arquivo: ");
            while (obj.entrada.ready()) {
                System.out.println(obj.entrada.readLine());
            }
            obj.entrada.close();
            //leitor.close();
        }

        File subdir = new File(diretorio, "subdir1");
        subdir.mkdir();
        String[] arquivos = diretorio.list();
        for (int i = 0; i < arquivos.length; i++) {
            File filho = new File(diretorio, arquivos[i]);
            System.out.println(filho.getAbsolutePath());
            System.out.println(filho.getParent());
            System.out.println("É diretorio? " + filho.isDirectory());
            System.out.println("É arquivo? " + filho.isFile());
            System.out.println("Tamanho = " + filho.length() + " bytes.");
        }
        /*        if (arquivo.exists()) {
            arquivo.delete();
        } else {
            arquivo.createNewFile();
        }*/
    }
}
