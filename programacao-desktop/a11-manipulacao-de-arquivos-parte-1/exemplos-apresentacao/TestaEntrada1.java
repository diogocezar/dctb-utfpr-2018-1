import java.io.*;

class TestaEntrada1{
	public static void main(String[] args) throws IOException{
		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		int c = isr.read();
		System.out.printf("%c\n", c);
    }
}