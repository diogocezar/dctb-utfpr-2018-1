import java.io.*;

class TestaSaida{
	public static void main(String[] args) throws IOException{
		OutputStream os = new FileOutputStream("saida.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("Olá Java!");
		bw.close();
    }
}