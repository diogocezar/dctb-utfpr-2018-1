package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author fabricio@utfpr.edu.br
 */
public class TestaArquivoAula {
    public static int npastas = 0;
    public static int narquivos = 0;
    public static long tamanho = 0;
    
    public static void gravaResultado(File pasta)throws IOException{
        File arquivo = new File(pasta, "log.txt");
        FileWriter escritor = new FileWriter(arquivo, true);//append false
        BufferedWriter escritorbuff = new BufferedWriter(escritor);
        escritorbuff.write("Pasta Listada: "+pasta.getAbsolutePath()+"\n");
        escritorbuff.write("Numero de Arquivos = "+narquivos+"\n");
        escritorbuff.write("Numero de Pastas = "+npastas+"\n");
        escritorbuff.write("Tamanho Ocupado em bytes = "+tamanho+"\n");
        escritorbuff.write("\n\n\n");
        escritorbuff.flush();
        escritorbuff.close();
    }
    
    public static void leResultado(File pasta)throws IOException{
        File arquivo = new File(pasta, "log.txt");
        FileReader leitor = new FileReader(arquivo);
        BufferedReader leitorbuff = new BufferedReader(leitor);
        while(leitorbuff.ready()){
            System.out.println(leitorbuff.readLine());
        }
        leitorbuff.close();
    }

    public static void listaPasta(File filho) {
        tamanho += filho.length();
        if (filho.isFile()){
            narquivos++;
        }else if (filho.isDirectory()){
            npastas++;
            System.out.println(filho.getName());
            String [] vet = filho.list();
            for (int i = 0; i < vet.length; i++){
                File neto = new File(filho, vet[i]);
                System.out.println(neto.getName());
                listaPasta(neto);
            }
        }
//        System.out.println(filho.getAbsolutePath());
//        System.out.println(filho.getParent());
//        System.out.println("É diretorio? " + filho.isDirectory());
//        System.out.println("É arquivo? " + filho.isFile());
//        System.out.println("Tamanho = " + filho.length() + " bytes.");
    }

    public static void main(String[] args)
            throws IOException {
        String caminho = JOptionPane.showInputDialog(
                null,
                "Digite uma pasta para listar: ",
                "Entrada de dados",
                JOptionPane.QUESTION_MESSAGE);

        if (caminho == null) {
            System.exit(0);
        }

        File diretorio = new File(caminho);
        diretorio.mkdir();
        File arquivo = new File(diretorio, "lixo.txt");
        File subdir = new File(diretorio, "subdir1");
        subdir.mkdir();
        String[] arquivos = diretorio.list();
        for (int i = 0; i < arquivos.length; i++) {
            File filho = new File(diretorio, arquivos[i]);
            listaPasta(filho);
        }
        gravaResultado(diretorio);
        leResultado(diretorio);
        
        if (arquivo.exists()) {
            arquivo.delete();
        } else {
            arquivo.createNewFile();
        }
    }
}
