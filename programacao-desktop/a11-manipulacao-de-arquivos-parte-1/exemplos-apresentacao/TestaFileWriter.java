import java.io.*;

class TestaFileWriter{
	public static void main(String[] args) throws IOException{
		FileWriter w = new FileWriter("saida.txt");
		PrintWriter out = new PrintWriter(w);
		out.println("Testando 123");
		out.println("Novo teste!");
		out.close();
		w.close();
    }
}