import java.io.File;
import java.io.IOException;
public class TestaFile {
    public static void main(String[] args) throws IOException {
        File diretorio = new File("./temp");
        diretorio.mkdir();
        File arquivo = new File(diretorio, "lixo.txt");
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
        if (arquivo.exists()) {
            arquivo.delete();
        } else {
            arquivo.createNewFile();
        }
    }
}