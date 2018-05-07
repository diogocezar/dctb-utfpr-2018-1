package Model;

import View.CadastrarEvento;
import java.io.*;

public class SalvarTxt{
    CadastrarEvento evt = new CadastrarEvento();
    
    public void salvarTxt() throws IOException{
        OutputStream saida = new FileOutputStream("CadastroEvento.txt");
        OutputStreamWriter saidaescrita = new OutputStreamWriter(saida);
        BufferedWriter escrever = new BufferedWriter(saidaescrita);        
    }
}
