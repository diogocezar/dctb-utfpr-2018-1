package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestaArquivoBinario {

    public static ObjectOutputStream CriaEscritorBinario(File arquivo, boolean append) {
        ObjectOutputStream out = null;

        try {
            FileOutputStream fos = new FileOutputStream(arquivo, append);
            out = new ObjectOutputStream(fos);
            /*
            if (arquivo.exists()) {
                FileOutputStream fos = new FileOutputStream(arquivo, append);
                out = new ObjectOutputStream(fos) {
                    @Override
                    protected void writeStreamHeader() {
                        // do not write a header
                    }
                };
            } else {
                FileOutputStream fos = new FileOutputStream(arquivo, append);
                out = new ObjectOutputStream(fos);
            }
             */
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }

    public static ObjectInputStream CriaLeitorBinario(File arquivo) {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            ois = new ObjectInputStream(fis);
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo. " + erro);
        }
        return ois;
    }

    public static void EscreveObjeto(ObjectOutputStream oos, Object obj, boolean flush) {
        try {
            oos.writeObject(obj);
            if (flush) {
                oos.flush();
            }
        } catch (IOException erro) {
            System.out.println("Erro na escrita. " + erro);
        }
    }

    public static Object LeObjeto(ObjectInputStream ois) {
        Object objlido = null;
        try {
            objlido = ois.readObject();
        } catch (ClassNotFoundException erro) {
            System.out.println("Classe nao encontrada. " + erro);
        } catch (java.io.EOFException erro) {
            System.out.println("Final de arquivo. " + erro);
        } catch (IOException erro) {
            System.out.println("Erro na leitura do objeto. " + erro);
        } finally {
            return objlido;
        }
    }

    public static void imprimeCliente(Cliente cli) {
        if (cli != null) {
            System.out.println(cli.toString());
        } else {
            System.out.println("Cliente nulo.");
        }
    }

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Zezinho", "3354-2000", 53);
        Cliente c2 = new Cliente("Huginho", "3354-2000", 50);
        Cliente c3 = new Cliente("Luizinho", "3354-2000", 51);
        File arquivo = new File("/media/arquivos/temp/e12.obj");
        ObjectOutputStream escritor = CriaEscritorBinario(arquivo, true);
        EscreveObjeto(escritor, c1, false);
        EscreveObjeto(escritor, c2, false);
        EscreveObjeto(escritor, c3, true);

        ObjectInputStream leitor = CriaLeitorBinario(arquivo);
        Cliente c4 = (Cliente) LeObjeto(leitor);
        imprimeCliente(c4);

        Cliente c5 = (Cliente) LeObjeto(leitor);
        imprimeCliente(c5);

        Cliente c6 = (Cliente) LeObjeto(leitor);
        imprimeCliente(c6);

        Cliente c7 = (Cliente) LeObjeto(leitor);
        imprimeCliente(c7);

    }
}
