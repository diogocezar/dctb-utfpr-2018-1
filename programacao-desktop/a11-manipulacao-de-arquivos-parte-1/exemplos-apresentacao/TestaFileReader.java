import java.io.*;

class TestaFileReader{
	public static void main(String[] args) throws IOException{
		FileReader r = new FileReader("saida.txt");
		BufferedReader in = new BufferedReader(r);
		String line = in.readLine();
		while(line != null){
			System.out.println(line);
			line = in.readLine();
		}
		in.close();
		r.close();
    }
}