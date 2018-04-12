package jogorpg;

/**
 *
 * @author Erik Lima
 */
public class Monster extends Creature {

    public Monster(String nome, String clases, double nivel, double vida, double magia, double força, double agilidade, double destreza, double intelligencia, double carisma) {
        super(nome, clases, nivel, vida, magia, força, agilidade, destreza, intelligencia, carisma);
    }
            
            
            //===methods==
  
   

    


    @Override
    public double descancar(double vida, double nivel) {
        Aleatorio r = new Aleatorio();
        double num =r.GerarNumeroAleatorio(11, 66);
        return getVida() + getNivel()* (num/100);
        
        
      }

  
    
    
         
    
  
    
    
}
