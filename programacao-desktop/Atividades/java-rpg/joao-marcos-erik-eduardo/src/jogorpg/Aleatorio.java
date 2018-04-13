
package jogorpg;

import java.util.Random;

/**
 *
 * @author Erik Lima
 */
public class Aleatorio {

   
    
    public int GerarNumeroAleatorio(int min, int max){

    Random rand = new Random();
    int randomNum =  (rand.nextInt( ((max - min) + 1)) + min);

    return randomNum;
}

    
}
