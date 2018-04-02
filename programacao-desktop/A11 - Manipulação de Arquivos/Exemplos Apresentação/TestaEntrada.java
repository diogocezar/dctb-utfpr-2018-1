import java.io.*;

class TestaEntrada{
	public static void main(String[] args) throws IOException{
		InputStream is = new FileInputStream("arquivo.txt");
		int b = is.read();
        System.out.println(b);
    }
}