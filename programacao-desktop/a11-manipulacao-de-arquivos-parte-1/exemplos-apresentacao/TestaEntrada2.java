import java.io.*;

class TestaEntrada2{
	public static void main(String[] args) throws IOException{
		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		System.out.println(s);
    }
}