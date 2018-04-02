import java.io.*;

class TestaEntrada3{
	public static void main(String[] args) throws IOException{
		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		while(s != null){
			System.out.println(s);
			s = br.readLine();
		}
		br.close();
    }
}