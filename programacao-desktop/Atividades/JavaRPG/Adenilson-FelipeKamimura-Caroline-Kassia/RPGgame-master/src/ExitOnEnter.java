import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ExitOnEnter
 */
public class ExitOnEnter {

    public boolean listener() {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("\nPressione Enter para continuar...");
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if((s == null) || (s.length() == 0) || (s.trim().equals(""))){
                System.out.println("\n\n");
                return true;
            } else {
                System.err.println("\n\nEntrada Errada. Tente Novamente.\n");
            }
        }
    }
}