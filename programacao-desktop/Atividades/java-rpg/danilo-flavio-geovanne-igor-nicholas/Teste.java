import java.util.Random;

public class Teste{
    public static void main (String[] args){
        int i =0;
        while(i<500){
            final float max = 1.66f;
            final float min = 1.10f;
            Random gerador = new Random(); //numero aleatorio para o ataque e defesa
            float numero = (gerador.nextFloat()*(max - min)) + min;
            System.out.println(numero+"\n");
            i++;
        }
    }
}