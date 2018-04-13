
package jogorpg;

/**
 *
 * @author Erik Lima
 */
public class Hero extends Creature {
   

   public Hero(String nome, String clases, double nivel, double vida, double magia, double força, double agilidade, double destreza, double intelligencia, double carisma, double bencao) {
        super(nome, clases, nivel, vida, magia, força, agilidade, destreza, intelligencia, carisma);
        this.bencao = bencao;
    }
   private double bencao;
   
    public double getBencao() {
        return bencao;
    }

    public void setBencao(double bencao) {
        this.bencao = bencao;
    }
    
     
    

  
    @Override
    public double descancar(double vida, double nivel) {
    // double benca = getBencao();
      Aleatorio r = new Aleatorio();
      double num =r.GerarNumeroAleatorio(11, 66);
        return getVida() + getNivel() * (num/100);
      
    }
   @Override
      public void _toString(){
        System.out.println("Nome "+getNome());
        System.out.println("Nivel "+ getNivel());
        System.out.println("Vida " + getVida());
        System.out.println("Magia "+ getMagia());
        System.out.println("Força "+ getForca());
        System.out.println("Agilidade "+ getAgilidade());
        System.out.println("Deztreza "+ getDestreza());
        System.out.println("Inteligencia "+ getIntelligencia());
        System.out.println("Carisma "+ getCarisma());
         System.out.println("Benção "+ getBencao());
        
        
        
    }
}